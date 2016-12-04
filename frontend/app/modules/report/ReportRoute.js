/* global angular */
'use strict';

/**
 * @ngdoc function
 * @name app.route:reportRoute
 * @description
 * # reportRoute
 * Route of the app
 */

angular.module('report')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('home.reports', {
                url: '/reports',
                templateUrl: 'app/modules/report/ReportView.html',
                controller: 'ReportController',
                controllerAs: 'vm',
                params: {
                    title: 'Reports',
                    icon: 'assessment'
                }
            });
    }]);
