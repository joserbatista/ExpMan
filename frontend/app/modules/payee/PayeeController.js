/* global angular */
(function() {
    'use strict';

    angular
        .module('payee')
        .controller('PayeeController', Payee);

    function Payee(PayeeService) {
        var vm = this;
        vm.isLoading = true;
        vm.payees = [];

        // fetch all payees for the current user
        vm.getUserCategories = function() {
            vm.isLoading = true;
            PayeeService.getUserPayees(function(response) {
                vm.isLoading = false;
                vm.payees = response;
            }, function(statusCode) {
                //FIXME show error message
            });
        };

        initController();

        function initController() {
            vm.getUserCategories();
        };
    }
})();
