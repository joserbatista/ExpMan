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
        'md.data.table',

        //ExpMan modules
        'account',
        'report',
        'payee',
        'category'
    ]);

    // custom filters
    angular.module('expman').filter('makeTypeReadable', function() {
        return function(item) {
            if (angular.isUndefined(item)) return item;

            return item.charAt(0).toUpperCase() + item.slice(1).toLowerCase()
                // Replaces any - or _ characters with a space
                .replace(/[-_]+/g, ' ')
                // Uppercases the first character in each group immediately following a space
                // (delimited by spaces)
                .replace(/ (.)/g, function($1) {
                    return $1.toUpperCase();
                }) || item;
        };
    });

    angular.module('expman').filter('makeNumberEuro', function() {
        return function(item) {
            if (angular.isUndefined(item)) return item;

            return item.toFixed(2) + ' €';
        };
    });

    angular.module('expman').filter('handleEmptyLabel', function() {
        return function(item) {
            if (!item) return '-';

            return item;
        };
    });
})();
