/* global angular */
(function () {
    'use strict';

    angular
        .module('expman')
        .controller('IndexController', Controller);

    function Controller($location, $state, $mdDialog, $mdSidenav, $rootScope, IndexService) {
        var vm = this;

        initController();

        function initController() {
            vm.sidebarItems = IndexService.getSidebarItems()

            updateCurrentItem($rootScope.$state.current);

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

            vm.navigateTo = function (target) {
                var page = target;
                $state.go(page).then(function () {
                    updateCurrentItem($state);
                })
            };
        }

        function updateCurrentItem(newState) {
            vm.currentItem = {
                name: newState.params.title,
                icon: newState.params.icon
            };
        }
    }
})();
