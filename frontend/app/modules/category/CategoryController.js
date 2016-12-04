/* global angular */
(function () {
    'use strict';

    angular
        .module('category')
        .controller('CategoryController', Category);

    function Category(CategoryService) {
        var vm = this;
        vm.isLoading = true;
        vm.categories = [];

        // fetch all categories for the current user
        vm.getUserCategories = function() {
            vm.isLoading = true;
            CategoryService.getUserCategories(function(response) {
                vm.isLoading = false;
                vm.categories = response;
            }, function(statusCode) {
                //FIXME show error message
            });
        };

        initController();

        function initController() {
            vm.getUserCategories();
        };
    }
})();
