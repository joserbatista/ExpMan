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
    // Inject your dependencies as .$inject = ['$http', 'someSevide'];
    // function Name ($http, someSevide) {...}

    Account.$inject = ['$http'];

    function Account($http) {

    }
})();
