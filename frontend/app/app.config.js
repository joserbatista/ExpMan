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
        .config(addInterceptor)
        .constant('$config', {
            appName: 'ExpMan',
            appVersion: '0.0.1',
            apiUrl: 'http://localhost:8080/api'
        })
        .run(runBlock);

    configure.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider', '$httpProvider', '$mdThemingProvider', '$mdIconProvider'];

    addInterceptor.$inject = ['$httpProvider', '$locationProvider'];

    /**
     * Intercept request to redirect to login if code is 401
     *
     * @param $httpProvider the http provider
     * @param $location     the location
     */
    function addInterceptor($httpProvider, $location) {

        $httpProvider.interceptors.push(function ($q) {

            return {

                'responseError': function (rejection) {

                    var defer = $q.defer();

                    if (rejection.status == 401) {
                        $location.path('/login');
                        return;
                    }

                    defer.reject(rejection);

                    return defer.promise;

                }
            };
        });
    }

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

    function runBlock($rootScope, $http, $location, $localStorage, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
        // keep user logged in after page refresh
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = $localStorage.currentUser.token;
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
