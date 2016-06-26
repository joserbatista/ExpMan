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

    function Account($http, $localStorage) {
        var service = {};

        service.getUserAccounts = function (successCallback, errorCallback) {
            $http.get('http://localhost:8080/api/user/account', {}).then(function (response) {
                if (response.data) {
                    successCallback(response.data);
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        };

        service.getAccountTypes = function (successCallback, errorCallback) {
            $http.get('http://localhost:8080/api/user/account/types', {}).then(function (response) {
                if (response.data) {
                    successCallback(response.data);
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
