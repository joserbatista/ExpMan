/* global angular */
'use strict';

/**
 * @ngdoc function
 * @name app.route:categoryRoute
 * @description
 * # categoryRoute
 * Route of the app
 */

angular.module('category')
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('home.categories', {
                url: '/categories',
                templateUrl: 'app/modules/category/CategoryView.html',
                controller: 'CategoryController',
                controllerAs: 'vm',
                params: {
                    title: 'Categories',
                    icon: 'label'
                }
            });
    }]);
