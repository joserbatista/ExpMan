/* global angular */
'use strict';

/**
 * @ngdoc function
 * @name app.route:accountRoute
 * @description
 * # accountRoute
 * Route of the app
 */

angular.module('account')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('home.accounts', {
                url: '/accounts',
                templateUrl: 'app/modules/account/AccountView.html',
                controller: 'AccountController',
                controllerAs: 'vm',
                params: {
                    title: 'Accounts',
                    icon: 'account_balance'
                }
            });
    }]);
