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
                'icon': 'face',
                'link': '',
                'name': 'Account'
            }];
        }
        return service;
    }
})();
