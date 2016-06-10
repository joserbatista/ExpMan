/* global angular */
(function () {
    'use strict';

    /**
     * @ngdoc configuration file
     * @name app.config:config
     * @description
     * # Config and run block
     * configuration of the app
     */

    angular
        .module('expman')
        .config(configure)
        .run(runBlock);

    configure.$inject = ['$stateProvider', '$urlRouterProvider',
        '$locationProvider', '$httpProvider', '$mdThemingProvider',
        '$mdIconProvider'
    ];

    function configure($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider, $mdThemingProvider, $mdIconProvider) {
        // default route
        $urlRouterProvider.otherwise('/dashboard');

        // use the HTML5 History API
        //$locationProvider.html5Mode(true);

        // This is required for Browser Sync to work poperly
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        // AngularMaterial Theming
        $mdThemingProvider.theme('default')
            .primaryPalette('blue-grey')
            .accentPalette('grey');
        // AngularMaterial icons
        $mdIconProvider.fontSet('md', 'material-icons');
    }

    function runBlock($rootScope, $http, $location, $localStorage) {
        // keep user logged in after page refresh
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }

        // redirect to login page if not logged in and trying to access a restricted page
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            var publicPages = ['/login'];
            var restrictedPage = publicPages.indexOf($location.path()) === -1;
            if (restrictedPage && !$localStorage.currentUser) {
                $location.path('/login');
            }
        });
    }
})();
