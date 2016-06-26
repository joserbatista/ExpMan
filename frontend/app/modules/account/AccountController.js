/* global angular */
(function () {
    'use strict';

    angular
            .module('account')
            .controller('AccountController', Account);

    function Account(AccountService, $mdDialog, $mdMedia) {
        var vm = this;
        vm.userAccounts = [];

            // fetch all accounts for the current user
        vm.getUserAccounts = function () {
            AccountService.getUserAccounts(function (response) {
                vm.userAccounts = response;
            }, function (statusCode) {
                    //FIXME show error message
            });
        };

            // map account enum to icon name
        vm.accountTypeIconMapping = {
            'CASH': 'euro_symbol',
            'BANK': 'account_balance',
            'CREDIT_CARD': 'credit_card',
            'DEBIT_CARD': 'credit_card',
            'PAYPAL': 'card_membership'
        };

            // show new account dialog
            // TODO do server request, update table
        vm.showNewAccountDialog = function ($event) {
            $mdDialog.show({
                fullscreen: ($mdMedia('sm') || $mdMedia('xs')),
                controller: NewAccountDialogController,
                templateUrl: 'app/modules/account/AccountNewDialogView.html',
                targetEvent: $event
            }).then(function () {}, function () {});

            function NewAccountDialogController($scope, $mdDialog, AccountService) {
                var dm = $scope;
                dm.accountTypes = [];
                dm.cancel = function () {
                    $mdDialog.hide();
                };

                    // fetch all account types
                dm.getAccountTypes = function () {
                    AccountService.getAccountTypes(function (response) {
                        dm.accountTypes = response;
                    }, function (statusCode) {
                            //FIXME show error message
                    });
                }
            }
        };

            // show edit account dialog
            // TODO do server request, update table
        vm.showEditAccountDialog = function ($event, account) {
            $mdDialog.show({
                fullscreen: ($mdMedia('sm') || $mdMedia('xs')),
                controller: DialogController,
                templateUrl: 'app/modules/account/AccountEditDialogView.html',
                targetEvent: $event,
                locals: {
                    accountToEdit: angular.copy(account)
                }
            }).then(function () {}, function () {});

            function DialogController($scope, $mdDialog, AccountService, accountToEdit) {
                var dm = $scope;
                dm.accountTypes = [];
                dm.account = accountToEdit;

                dm.cancel = function () {
                    $mdDialog.hide();
                };

                    // fetch all account types
                AccountService.getAccountTypes(function (response) {
                    dm.accountTypes = response;
                    dm.account = accountToEdit;
                }, function (statusCode) {
                        //FIXME show error message
                });
            }
        };

        initController();

        function initController() {
            vm.getUserAccounts();
        };
    }

    angular.module('account').filter('makeTypeReadable', function () {
        return function (item) {
            if (angular.isUndefined(item)) return item;

            return item.charAt(0).toUpperCase() + item.slice(1).toLowerCase()
                    // Replaces any - or _ characters with a space
                    .replace(/[-_]+/g, ' ')
                    // Uppercases the first character in each group immediately following a space
                    // (delimited by spaces)
                    .replace(/ (.)/g, function ($1) {
                        return $1.toUpperCase();
                    }) || item;
        };
    });
    angular.module('account').filter('makeNumberEuro', function () {
        return function (item) {
            if (angular.isUndefined(item)) return item;

            return item.toFixed(2) + ' €';
        };
    });
})();
