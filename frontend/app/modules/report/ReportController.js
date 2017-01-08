/* global angular, console   */
(function() {
    'use strict';

    angular
        .module('report')
        .controller('ReportController', Report);

    function Report(ReportService, $rootScope) {
        var vm = this;
        vm.isLoading = true;

        vm.transactions = {
            list: [],
            count: 0
        };

        vm.query = {
            order: 'date',
            limit: 25,
            page: 1
        };

        var filter = {
            endDate: (new Date()).toISOString(),
            startDate: '2016-09-01T00:00:00+00:00'
        };
        // fetch transactions for the current user based on filter
        vm.getUserTransactions = function() {
            vm.isLoading = true;
            ReportService.getUserTransactions(filter, function(response) {
                vm.isLoading = false;
                vm.transactions.list = response.transactions;
                vm.transactions.count = response.transactionsCount;
            }, function(statusCode) {
                //FIXME show error message
            });
        };

        $rootScope.executeToolbarAction = function(action) {
            switch (action) {
                case 'filterTransactions':
                    break;
                default:
                    console.error('Invalid Action ' + action + ' !')
            }
        }

        initController();

        function initController() {
            vm.getUserTransactions();
        };
    }
})();
