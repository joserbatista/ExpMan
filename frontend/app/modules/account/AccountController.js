/* global angular */
(function() {
    'use strict';

    angular
        .module('account')
        .controller('AccountController', Account);

    function Account(AccountService, $mdDialog, $mdMedia, $mdToast) {
        var vm = this;
        vm.isLoading = true;
        vm.userAccounts = [];

        // fetch all accounts for the current user
        vm.getUserAccounts = function() {
            vm.isLoading = true;
            AccountService.getUserAccounts(function(response) {
                vm.isLoading = false;
                vm.userAccounts = response;
            }, function(statusCode) {
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
        // TODO update table
        vm.showNewAccountDialog = function($event) {
            $mdDialog.show({
                fullscreen: ($mdMedia('sm') || $mdMedia('xs')),
                controller: NewAccountDialogController,
                templateUrl: 'app/modules/account/AccountNewDialogView.html',
                targetEvent: $event
            }).then(function(account) {
                $mdToast.show(
                    $mdToast.simple()
                    .position('top right')
                    .textContent('Account \"' + account.name + '\" created.')
                    .hideDelay(3000)
                );
                vm.getUserAccounts();
            }, function() {});

            function NewAccountDialogController($scope, $mdDialog, AccountService) {
                var dm = $scope;
                dm.accountTypes = [];
                dm.cancel = function() {
                    $mdDialog.cancel();
                };

                dm.create = function() {
                    // update account on server
                    AccountService.createAccount(dm.account, function(response) {
                        $mdDialog.hide(dm.account);
                    }, function(statusCode) {
                        //FIXME show error message
                    });
                }

                // fetch all account types
                dm.getAccountTypes = function() {
                    dm.isLoadingTypes = true;
                    AccountService.getAccountTypes(function(response) {
                        dm.isLoadingTypes = false;
                        dm.accountTypes = response;
                    }, function(statusCode) {
                        //FIXME show error message
                    });
                }
            }
        };

        // show edit account dialog
        // TODO  update table
        vm.showEditAccountDialog = function($event, account) {
            $mdDialog.show({
                fullscreen: ($mdMedia('sm') || $mdMedia('xs')),
                controller: DialogController,
                templateUrl: 'app/modules/account/AccountEditDialogView.html',
                targetEvent: $event,
                locals: {
                    accountToEdit: angular.copy(account)
                }
            }).then(function(action) {
                $mdToast.show(
                    $mdToast.simple()
                    .position('top right')
                    .textContent('Account \"' + account.name + '\" ' + action + '.')
                    .hideDelay(3000)
                );
                vm.getUserAccounts();
            }, function() {});

            function DialogController($scope, $mdDialog, AccountService, accountToEdit) {
                var dm = $scope;
                dm.accountTypes = [];
                dm.isConfirmation = false;
                dm.account = accountToEdit;

                dm.cancel = function() {
                    $mdDialog.cancel();
                };

                dm.save = function() {
                    // update account on server
                    AccountService.updateAccount(accountToEdit, function(response) {
                        $mdDialog.hide('updated');
                    }, function(statusCode) {
                        //FIXME show error message
                    });
                }

                dm.confirmRemove = function(confirm) {
                    dm.isConfirmation = confirm;
                }

                dm.remove = function() {
                    // update account on server
                    AccountService.removeAccount(accountToEdit, function(response) {
                        $mdDialog.hide('removed');
                    }, function(statusCode) {
                        //FIXME show error message
                    });
                }

                // fetch all account types
                dm.isLoadingTypes = true;
                AccountService.getAccountTypes(function(response) {
                    dm.isLoadingTypes = false;
                    dm.accountTypes = response;
                }, function(statusCode) {
                    //FIXME show error message
                });
            }
        };

        initController();

        function initController() {
            vm.getUserAccounts();
        };
    };
})();
