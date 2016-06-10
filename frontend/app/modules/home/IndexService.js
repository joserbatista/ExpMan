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
                'link': '',
                'name': 'Accounts'
            }, {
                'icon': 'assessment',
                'link': '',
                'name': 'Reports'
            }, {
                'icon': 'person',
                'link': '',
                'name': 'Payees'
            }, {
                'icon': 'label',
                'link': '',
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
