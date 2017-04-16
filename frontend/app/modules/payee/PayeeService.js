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

    function Payee($http, $config) {
        var service = {};

        // function to get user payees
        service.getUserPayees = function(successCallback, errorCallback) {
            $http.get($config.apiUrl + '/user/payee').then(function(response) {
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
