/* global angular */
(function () {
    'use strict';

    angular
        .module('expman')
        .controller('LoginController', Controller);

    function Controller($location, AuthenticationService, $mdToast) {
        var vm = this;
        vm.hasError = false;
        vm.isLoading = false;

        vm.login = function () {
            vm.hasError = false;
            vm.isLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (result) {
                $location.path('/');
            }, function (statusCode) {
                vm.isLoading = false;
                vm.hasError = true;

                vm.errorText =
                    statusCode === 401
                    ? 'Invalid username or password, please try again.'
                    : 'An unknown error occurred, please try again (' + statusCode + ').';
            });
        };

        initController();

        function initController() {
            // reset login status
            AuthenticationService.Logout();
        };
    }
})();
