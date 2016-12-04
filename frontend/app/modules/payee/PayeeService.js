/* global angular */
(function() {
    'use strict';

    /**
     * @ngdoc function
     * @name app.service:payeeService
     * @description
     * # payeeService
     * Service of the app
     */

    angular
        .module('payee')
        .factory('PayeeService', Payee);
    // Inject your dependencies as .$inject = ['$http', 'someSevide'];
    // function Name ($http, someSevide) {...}

    Payee.$inject = ['$http'];

    function Payee($http) {
        var service = {};

        // function to get user payees
        service.getUserPayees = function(successCallback, errorCallback) {
            $http.get('http://localhost:8080/api/user/payee').then(function(response) {
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
