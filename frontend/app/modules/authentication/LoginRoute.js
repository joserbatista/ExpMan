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
            .state('login', {
                url: '/login',
                templateUrl: '/app/modules/authentication/LoginView.html',
                controller: 'LoginController',
                controllerAs: 'vm'
            })
    }]);
