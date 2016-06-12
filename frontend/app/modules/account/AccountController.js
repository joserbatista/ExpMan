/* global angular */
(function () {
    'use strict';

    angular
        .module('account')
        .controller('AccountController', Account);

    Account.$inject = [];

    function Account() {
        /*jshint validthis: true */
        var vm = this;
    }
})();
