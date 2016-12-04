/* global angular */
(function() {
    'use strict';

    /**
     * @ngdoc function
     * @name app.service:categoryService
     * @description
     * # categoryService
     * Service of the app
     */

    angular
        .module('category')
        .factory('CategoryService', Category);
    // Inject your dependencies as .$inject = ['$http', 'someSevide'];
    // function Name ($http, someSevide) {...}

    Category.$inject = ['$http'];

    function Category($http) {
        var service = {};

        // function to get user accounts
        service.getUserCategories = function(successCallback, errorCallback) {
            $http.get('http://localhost:8080/api/user/category').then(function(response) {
                if (response.data || response.status === 200) {
                    successCallback(response.data);
                } else {
                    errorCallback(401);
                }
            }, function(response) {
                errorCallback(response.status);
            });
        };

        return service;
    }
})();
