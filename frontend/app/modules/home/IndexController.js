/* global angular */
(function () {
    'use strict';

    angular
        .module('expman')
        .controller('IndexController', Controller);

    function Controller(IndexService) {
        var vm = this;

        initController();

        function initController() {
            vm.sidebarItems = IndexService.getSidebarItems()
        }
    }
})();
