/* global angular */
(function () {
    'use strict';

    angular
        .module('expman')
        .controller('IndexController', Controller);

    function Controller($location, $mdDialog, $mdSidenav, $rootScope, IndexService) {
        var vm = this;

        initController();

        function initController() {
            vm.sidebarItems = IndexService.getSidebarItems()

            vm.currentItem = {
                name: $rootScope.$state.current.params.title,
                icon: $rootScope.$state.current.params.icon
            };

            vm.logout = function () {
                var confirm = $mdDialog.confirm()
                            .clickOutsideToClose(true)
                            .title('Logout')
                            .textContent('Are you sure you want to logout?')
                            .ariaLabel('Logout')
                            .ok('Logout')
                            .cancel('Cancel');

                $mdDialog.show(confirm).then(function () {
                    $location.path('/login')
                });
            }

            vm.openLeftMenu = function () {
                $mdSidenav('left').toggle();
            };
        }
    }
})();
