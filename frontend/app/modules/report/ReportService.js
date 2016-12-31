/* global angular */
(function() {
    'use strict';

    /**
     * @ngdoc function
     * @name app.service:reportService
     * @description
     * # reportService
     * Service of the app
     */

    angular
        .module('report')
        .factory('ReportService', Report);
    // Inject your dependencies as .$inject = ['$http', 'someSevide'];
    // function Name ($http, someSevide) {...}

    Report.$inject = ['$http'];

    function Report($http) {
        var service = {};

        // function to get user accounts

        /*
      {
        "filter": {
          "startDate": "2016-01-01T00:00:00+00:00",
          "endDate": "2016-12-31T23:00:00+00:00",
          "accountNames": ["Santander", "Carteira"],
          "categoryNames": ["Diário"],
          "payeeNames": ["McDonald's"]
        }
      }
      */
        service.getUserTransactions = function(filter, successCallback, errorCallback) {
            $http.post('http://localhost:8080/api/user/transaction/filter', filter).then(function(response) {
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
