/* global angular */
(function() {
    'use strict';

    /**
     * @ngdoc index
     * @name app
     * @description
     * # app
     *
     * Main module of the application.
     */

    angular.module('expman', [
        'ngResource',
        'ngAria',
        'ngMaterial',
        'ngMdIcons',
        'ngMessages',
        'ngCookies',
        'ngAnimate',
        'ngSanitize',
        'ngStorage',
        'ui.router',
        'anim-in-out',

        //ExpMan modules
        'account',
        'report',
        'payee',
        'category'
    ]);
})();
