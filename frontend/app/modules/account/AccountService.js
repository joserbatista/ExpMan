/* global angular */
(function () {
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

    function Account($http, $localStorage, $config) {
        var service = {};

        // function to get user accounts
        service.getUserAccounts = function (successCallback, errorCallback) {
            $http.get($config.apiUrl + '/user/account', {}).then(function (response) {
                if (response.data || response.status === 200) {
                    successCallback(response.data);
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        };

        // functions to get account types
        service.getAccountTypes = function (successCallback, errorCallback) {
            $http.get($config.apiUrl + '/user/account/types', {}).then(function (response) {
                if (response.data || response.status === 200) {
                    successCallback(response.data);
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        };

        // function to update account
        service.updateAccount = function (account, successCallback, errorCallback) {
            $http.post($config.apiUrl + '/user/account/edit', account).then(function (response) {
                if (response.data || response.status === 200) {
                    successCallback();
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        };

        // function to remove account
        service.removeAccount = function (account, successCallback, errorCallback) {
            $http.post($config.apiUrl + '/user/account/remove', account).then(function (response) {
                if (response.data || response.status === 200) {
                    successCallback();
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        };

        // function to create account
        service.createAccount = function (account, successCallback, errorCallback) {
            $http.post($config.apiUrl + '/user/account', account).then(function (response) {
                if (response.data || response.status === 200) {
                    successCallback();
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        };

        return service;
    }
})();
