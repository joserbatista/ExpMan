/* global angular */
(function() {
    'use strict';

    /**
     * @ngdoc function
     * @name app.service:accountService
     * @description
     * # accountService
     * Service of the app
     */

    angular
        .module('account')
        .factory('AccountService', Account);

    function Account($http, $localStorage) {
        var service = {};

        // function to get user accounts
        service.getUserAccounts = function(successCallback, errorCallback) {
            $http.get('http://localhost:8080/api/user/account', {}).then(function(response) {
                if (response.data) {
                    successCallback(response.data);
                } else {
                    errorCallback(401);
                }
            }, function(response) {
                errorCallback(response.status);
            });
        };

        // functions to get account types
        service.getAccountTypes = function(successCallback, errorCallback) {
            $http.get('http://localhost:8080/api/user/account/types', {}).then(function(response) {
                if (response.data) {
                    successCallback(response.data);
                } else {
                    errorCallback(401);
                }
            }, function(response) {
                errorCallback(response.status);
            });
        };

        // function to update account
        service.updateAccount = function(account, successCallback, errorCallback) {
            $http.post('http://localhost:8080/api/user/account/edit', account).then(function(response) {
                if (response.data) {
                    successCallback();
                } else {
                    errorCallback(401);
                }
            }, function(response) {
                errorCallback(response.status);
            });
        };

        // function to create account
        service.createAccount = function(account, successCallback, errorCallback) {
            $http.post('http://localhost:8080/api/user/account', account).then(function(response) {
                if (response.data) {
                    successCallback();
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
