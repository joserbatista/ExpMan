/* global angular */
'use strict';

/**
 * @ngdoc function
 * @name app.route:payeeRoute
 * @description
 * # payeeRoute
 * Route of the app
 */

angular.module('payee')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('home.payees', {
                url: '/payees',
                templateUrl: 'app/modules/payee/PayeeView.html',
                controller: 'PayeeController',
                controllerAs: 'vm',
                params: {
                    title: 'Payees',
                    icon: 'person'
                }
            });
    }]);
