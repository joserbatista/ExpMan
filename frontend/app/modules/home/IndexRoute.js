/* global angular */
'use strict';

/**
 * @ngdoc function
 * @name app.route:HomeRoute
 * @description
 * # HomeRoute
 * Route of the app
 */

angular.module('expman')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('home', {
                url: '',
                abstract: true,
                templateUrl: '/app/modules/home/IndexView.html',
                controller: 'IndexController',
                controllerAs: 'vm'
            })
            .state('home.dashboard', {
                url: '/dashboard',
                templateUrl: 'app/modules/home/DashboardView.html'
            });
    }]);
