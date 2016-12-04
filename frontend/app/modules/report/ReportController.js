/* global angular */
(function () {
    'use strict';

    angular
        .module('report')
        .controller('ReportController', Report);

    Report.$inject = [];

    function Report() {
        var vm = this;
    }
})();
