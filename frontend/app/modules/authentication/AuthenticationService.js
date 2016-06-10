/* global angular */
(function () {
    'use strict';

    angular
        .module('expman')
        .factory('AuthenticationService', Service);

    function Service($http, $localStorage) {
        var service = {};

        service.Login = Login;
        service.Logout = Logout;

        return service;

        function Login(username, password, successCallback, errorCallback) {
            $http.post('http://localhost:8080/auth', {
                username: username,
                password: password
            }).then(function (response) {
                // login successful if there's a token in the response
                if (response.data.token) {
                    // store username and token in local storage to keep user logged in between page refreshes
                    $localStorage.currentUser = {
                        username: username,
                        token: response.token
                    };

                    // add jwt token to auth header for all requests made by the $http service
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;

                    successCallback();
                } else {
                    errorCallback(401);
                }
            }, function (response) {
                errorCallback(response.status);
            });
        }

        function Logout() {
            // remove user from local storage and clear http auth header
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
        }
    }
})();
