/* global angular */

(function () {
    'use strict';

    /**
     * @ngdoc function
     * @name app.service:homeService
     * @description
     * # homeService
     * Service of the app
     */

    angular.module('expman')
        .factory('IndexService', Service);

    Service.$inject = [];

    function Service() {
        var service = {};

        service.getSidebarItems = function () {
            return [{
                'icon': 'account_balance',
                'link': 'accounts',
                'name': 'Accounts'
            }, {
                'icon': 'assessment',
                'link': 'reports',
                'name': 'Reports'
            }, {
                'icon': 'person',
                'link': 'payees',
                'name': 'Payees'
            }, {
                'icon': 'label',
                'link': 'categories',
                'name': 'Categories'
            }, {
                'icon': 'trending_up',
                'link': '',
                'name': 'Forecast'
            }];
        }
        return service;
    }
})();
