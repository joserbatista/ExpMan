/* global angular */
(function () {
    'use strict';

    angular
        .module('expman')
        .controller('LoginController', Controller);

    function Controller($location, AuthenticationService, $mdDialog) {
        var vm = this;
        vm.hasError = false;
        vm.isLoading = false;

        vm.login = function () {
            vm.hasError = false;
            vm.isLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (result) {
                AuthenticationService.GetUserData(function () {
                    $location.path('/');
                }, function () {
                    vm.isLoading = false;
                    vm.hasError = true;

                    vm.errorText = 'Your login succeeded, but an unexpected error occurred. Please try again.';
                });
            }, function (statusCode) {
                vm.isLoading = false;
                vm.hasError = true;

                vm.errorText =
                    statusCode === 401
                    ? 'Invalid username or password, please try again.'
                    : 'An unexpected error occurred, please try again (' + statusCode + ').';
            });
        };

        initController();

        function initController() {
            // reset login status
            AuthenticationService.Logout();
        };
    }
})();
