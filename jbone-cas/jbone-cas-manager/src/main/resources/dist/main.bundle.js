webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_services_component__ = __webpack_require__("../../../../../src/app/services/services.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_services_resolover__ = __webpack_require__("../../../../../src/app/services/services.resolover.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domains_domains_component__ = __webpack_require__("../../../../../src/app/domains/domains.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__search_search_component__ = __webpack_require__("../../../../../src/app/search/search.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__init_component__ = __webpack_require__("../../../../../src/app/init.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by tschmidt on 2/23/17.
 */







var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */].forRoot([
                    {
                        path: 'domains',
                        component: __WEBPACK_IMPORTED_MODULE_4__domains_domains_component__["a" /* DomainsComponent */],
                    },
                    {
                        path: 'services/:domain',
                        component: __WEBPACK_IMPORTED_MODULE_2__services_services_component__["a" /* ServicesComponent */],
                        resolve: {
                            resp: __WEBPACK_IMPORTED_MODULE_3__services_services_resolover__["a" /* ServicesResolve */]
                        }
                    },
                    {
                        path: 'search/:query',
                        component: __WEBPACK_IMPORTED_MODULE_5__search_search_component__["a" /* SearchComponent */]
                    },
                    {
                        path: 'manage.html',
                        component: __WEBPACK_IMPORTED_MODULE_6__init_component__["a" /* InitComponent */]
                    },
                ]),
            ],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"background-color: #f2f2f2;min-width:700px;\">\n  <app-header></app-header>\n  <div style=\"position:relative;top:51px;\">\n    <router-outlet></router-outlet>\n  </div>\n</div>\n<app-footer></app-footer>\n\n\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = (function () {
    function AppComponent(messages) {
        this.messages = messages;
    }
    AppComponent.prototype.ngOnInit = function () {
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_services_module__ = __webpack_require__("../../../../../src/app/services/services.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__header_header_component__ = __webpack_require__("../../../../../src/app/header/header.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__form_form_module__ = __webpack_require__("../../../../../src/app/form/form.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__delete_delete_component__ = __webpack_require__("../../../../../src/app/delete/delete.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__domains_domains_module__ = __webpack_require__("../../../../../src/app/domains/domains.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__search_search_component__ = __webpack_require__("../../../../../src/app/search/search.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__search_SearchService__ = __webpack_require__("../../../../../src/app/search/SearchService.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__header_header_service__ = __webpack_require__("../../../../../src/app/header/header.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16_app_init_component__ = __webpack_require__("../../../../../src/app/init.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__footer_footer_component__ = __webpack_require__("../../../../../src/app/footer/footer.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



















var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_18__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_12__domains_domains_module__["a" /* DomainsModule */],
                __WEBPACK_IMPORTED_MODULE_7__services_services_module__["a" /* ServicesModule */],
                __WEBPACK_IMPORTED_MODULE_10__form_form_module__["a" /* FormModule */],
                __WEBPACK_IMPORTED_MODULE_9__shared_shared_module__["a" /* SharedModule */],
                __WEBPACK_IMPORTED_MODULE_6__app_routing_module__["a" /* AppRoutingModule */]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_8__header_header_component__["a" /* HeaderComponent */],
                __WEBPACK_IMPORTED_MODULE_11__delete_delete_component__["a" /* DeleteComponent */],
                __WEBPACK_IMPORTED_MODULE_13__search_search_component__["a" /* SearchComponent */],
                __WEBPACK_IMPORTED_MODULE_16_app_init_component__["a" /* InitComponent */],
                __WEBPACK_IMPORTED_MODULE_17__footer_footer_component__["a" /* FooterComponent */],
            ],
            entryComponents: [
                __WEBPACK_IMPORTED_MODULE_11__delete_delete_component__["a" /* DeleteComponent */]
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_5__messages__["a" /* Messages */],
                __WEBPACK_IMPORTED_MODULE_14__search_SearchService__["a" /* SearchService */],
                __WEBPACK_IMPORTED_MODULE_15__header_header_service__["a" /* HeaderService */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/controls/controls.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/controls/controls.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <div style=\"display:inline;\" *ngIf=\"showEdit\">\n    <button mat-button (click)=\"save.emit();\">\n      <mat-icon>save</mat-icon>\n        <ng-container i18n=\"services.form.button.save\">\n            {{ messages.services_form_button_save }}\n        </ng-container>\n    </button>\n    <button mat-button (click)=\"goBack();\">\n      <mat-icon>cancel</mat-icon>\n        <ng-container i18n=\"services.form.button.cancel\">\n            {{ messages.services_form_button_cancel }}\n        </ng-container>\n    </button>\n  </div>\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/controls/controls.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ControlsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__controls_service__ = __webpack_require__("../../../../../src/app/controls/controls.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ControlsComponent = (function () {
    function ControlsComponent(messages, service, router, location) {
        this.messages = messages;
        this.service = service;
        this.router = router;
        this.location = location;
        this.save = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["x" /* EventEmitter */]();
    }
    ControlsComponent.prototype.ngOnInit = function () {
        this.showEdit = this.router.url.includes('form');
    };
    ControlsComponent.prototype.goBack = function () {
        this.location.back();
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["R" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["x" /* EventEmitter */])
    ], ControlsComponent.prototype, "save", void 0);
    ControlsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-controls',
            template: __webpack_require__("../../../../../src/app/controls/controls.component.html"),
            styles: [__webpack_require__("../../../../../src/app/controls/controls.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__controls_service__["a" /* ControlsService */],
            __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_4__angular_common__["f" /* Location */]])
    ], ControlsComponent);
    return ControlsComponent;
}());



/***/ }),

/***/ "../../../../../src/app/controls/controls.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ControlsService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service__ = __webpack_require__("../../../../../src/app/service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/**
 * Created by tsschmi on 2/28/17.
 */
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ControlsService = (function (_super) {
    __extends(ControlsService, _super);
    function ControlsService(http) {
        return _super.call(this, http) || this;
    }
    ControlsService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], ControlsService);
    return ControlsService;
}(__WEBPACK_IMPORTED_MODULE_1__service__["a" /* Service */]));



/***/ }),

/***/ "../../../../../src/app/delete/delete.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/delete/delete.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <h3 matDialogTitle>\n    <ng-container i18n=\"managemnet.services.table.modal.delete.header\">\n      {{messages.management_services_table_modal_delete_header}}\n    </ng-container>\n  </h3>\n</div>\n<mat-dialog-content>\n  <ng-container i18n=\"management.services.table.modal.delete.msgPt1\">\n    {{messages.management_services_table_modal_delete_msgPt1}}\n  </ng-container> {{ data != null ? data.name : '' }}.<br/>\n  <ng-container i18n=\"management.services.table.modal.delete.msgPt2\">\n          {{messages.management_services_table_modal_delete_msgPt2}}\n  </ng-container>\n</mat-dialog-content>\n<mat-dialog-actions style=\"float:right;\">\n  <div>\n    <button mat-button matDialogClose>\n      <mat-icon>cancel</mat-icon>\n      <ng-container i18n>Cancel</ng-container>\n    </button>\n    <button mat-button matDialogClose=\"true\">\n      <mat-icon>delete</mat-icon>\n      <ng-container i18n>Delete</ng-container>\n    </button>\n  </div>\n</mat-dialog-actions>\n\n"

/***/ }),

/***/ "../../../../../src/app/delete/delete.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DeleteComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};




var DeleteComponent = (function () {
    function DeleteComponent(dialogRef, data, messages) {
        this.dialogRef = dialogRef;
        this.data = data;
        this.messages = messages;
    }
    DeleteComponent.prototype.ngOnInit = function () {
    };
    DeleteComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-delete',
            template: __webpack_require__("../../../../../src/app/delete/delete.component.html"),
            styles: [__webpack_require__("../../../../../src/app/delete/delete.component.css")]
        }),
        __param(1, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["B" /* Inject */])(__WEBPACK_IMPORTED_MODULE_1__angular_material__["a" /* MAT_DIALOG_DATA */])),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_material__["j" /* MatDialogRef */], Object, __WEBPACK_IMPORTED_MODULE_2__messages__["a" /* Messages */]])
    ], DeleteComponent);
    return DeleteComponent;
}());



/***/ }),

/***/ "../../../../../src/app/domains/domain.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DomainService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__service__ = __webpack_require__("../../../../../src/app/service.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
/**
 * Created by tschmidt on 2/13/17.
 */



var DomainService = (function (_super) {
    __extends(DomainService, _super);
    function DomainService(http) {
        return _super.call(this, http) || this;
    }
    DomainService.prototype.getDomains = function () {
        return this.get('domainList');
    };
    DomainService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_0__angular_common_http__["a" /* HttpClient */]])
    ], DomainService);
    return DomainService;
}(__WEBPACK_IMPORTED_MODULE_2__service__["a" /* Service */]));



/***/ }),

/***/ "../../../../../src/app/domains/domains.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".nameWidth {\n    -webkit-box-flex: 1;\n        -ms-flex: 1 1 auto;\n            flex: 1 1 auto;\n}\n\n.actionWidth {\n    -webkit-box-flex: 0;\n        -ms-flex: 0 0 50px;\n            flex: 0 0 50px;\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/domains/domains.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"display:flex;margin-bottom:10px;\">\n  <div style=\"margin-left:25px;padding-top: 10px;\">\n    <mat-icon style=\"padding-top: 3px;\">build</mat-icon>\n    <h4 style=\"display: inline;position: relative;top: -5px;\">\n      <ng-container i18n>\n        Domains\n      </ng-container>\n    </h4>\n  </div>\n  <div style=\"flex: 1 1 auto;text-align: center\">\n  </div>\n  <div>\n    <app-controls></app-controls>\n  </div>\n\n</div>\n\n<div style=\"display: flex; flex-direction: column; margin-right:25px;margin-left:25px;\">\n<mat-table #table [dataSource]=\"dataSource\">\n\n  <ng-container matColumnDef=\"actions\">\n    <mat-header-cell *matHeaderCellDef [ngClass]=\"'actionWidth'\">\n      <ng-container i18n>\n        &nbsp;\n      </ng-container>\n    </mat-header-cell>\n    <mat-cell *matCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n      <button mat-icon-button [matMenuTriggerFor]=\"serviceMenu\" (click)=\"selectedItem = row\">\n        <mat-icon>menu</mat-icon>\n      </button>\n    </mat-cell>\n  </ng-container>\n\n  <ng-container matColumnDef=\"name\">\n    <mat-header-cell *matHeaderCellDef>\n      <mat-form-field floatPlaceholder=\"never\" style=\"width:100%;min-width:250px;max-width:750px;\">\n        <input matInput (keyup)=\"doFilter($event.target.value)\" placeholder=\"Filter Domains\" >\n      </mat-form-field>\n    </mat-header-cell>\n    <mat-cell *matCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n      <a (click)=\"view(row)\">\n        {{ row }}\n      </a>\n    </mat-cell>\n  </ng-container>\n\n  <mat-header-row *matHeaderRowDef=\"displayedColumns\"></mat-header-row>\n  <mat-row *matRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n</mat-table>\n\n<mat-paginator #paginator\n              [pageSize]=\"10\"\n              [pageSizeOptions]=\"[5, 10, 25, 100]\">\n</mat-paginator>\n</div>\n\n<mat-menu #serviceMenu>\n  <button mat-menu-item (click)=\"view(selectedItem)\">\n    <mat-icon>edit</mat-icon>\n    <ng-container i18n=\"management.services.table.button.edit\">\n      {{ messages.management_services_table_button_edit }}\n    </ng-container>\n  </button>\n</mat-menu>\n"

/***/ }),

/***/ "../../../../../src/app/domains/domains.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DomainsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_service__ = __webpack_require__("../../../../../src/app/domains/domain.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_app_messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DomainsComponent = (function () {
    function DomainsComponent(messages, router, domainService, snackBar, location) {
        this.messages = messages;
        this.router = router;
        this.domainService = domainService;
        this.snackBar = snackBar;
        this.location = location;
        this.displayedColumns = ['actions', 'name'];
    }
    DomainsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_1__angular_material__["y" /* MatTableDataSource */]([]);
        this.dataSource.paginator = this.paginator;
        this.domainService.getDomains()
            .then(function (resp) { return _this.dataSource.data = resp; })
            .catch(function (e) { console.log(e); _this.snackBar.open('Failed to load domains', 'Dismiss'); });
    };
    DomainsComponent.prototype.doFilter = function (val) {
        if (!this.dataSource) {
            return;
        }
        this.dataSource.filter = val;
    };
    DomainsComponent.prototype.view = function (domain) {
        this.router.navigate(['services', domain]);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])(__WEBPACK_IMPORTED_MODULE_1__angular_material__["q" /* MatPaginator */]),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1__angular_material__["q" /* MatPaginator */])
    ], DomainsComponent.prototype, "paginator", void 0);
    DomainsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-domains',
            template: __webpack_require__("../../../../../src/app/domains/domains.component.html"),
            styles: [__webpack_require__("../../../../../src/app/domains/domains.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3_app_messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_4__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__domain_service__["a" /* DomainService */],
            __WEBPACK_IMPORTED_MODULE_1__angular_material__["v" /* MatSnackBar */],
            __WEBPACK_IMPORTED_MODULE_5__angular_common__["f" /* Location */]])
    ], DomainsComponent);
    return DomainsComponent;
}());



/***/ }),

/***/ "../../../../../src/app/domains/domains.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DomainsModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domains_component__ = __webpack_require__("../../../../../src/app/domains/domains.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__domain_service__ = __webpack_require__("../../../../../src/app/domains/domain.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by tschmidt on 2/23/17.
 */







var DomainsModule = (function () {
    function DomainsModule() {
    }
    DomainsModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_common__["b" /* CommonModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_http__["b" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_6__shared_shared_module__["a" /* SharedModule */]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__domains_component__["a" /* DomainsComponent */]
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_5__domain_service__["a" /* DomainService */]
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_4__domains_component__["a" /* DomainsComponent */]
            ]
        })
    ], DomainsModule);
    return DomainsModule;
}());



/***/ }),

/***/ "../../../../../src/app/footer/footer.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".footer {\n    background-color: #e6e6e6;\n    border-top: 5px solid #256d8d;\n    position: fixed;\n    bottom: 0;\n    width: 100%;\n    font-size: 80%;\n    display:-webkit-box;\n    display:-ms-flexbox;\n    display:flex;\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/footer/footer.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"footer\">\n  <div>\n    <p>\n      <span >Copyright &copy; 2005 - 2017 Apereo, Inc.</span>\n      <span >Powered by <a href=\"http://www.apereo.org/cas\">Apereo Central Authentication Service 5.2.0-SNAPSHOT</a></span>\n    </p>\n  </div>\n  <div style=\"flex: 1 1 auto;\"></div>\n  <div>\n    <a href=\"https://www.apereo.org\" _target=\"blank\" title=\"Apereo CAS Home Page\">\n      <img src=\"images/logo_apereo.png\" style=\"height:30px;\"/></a>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/footer/footer.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FooterComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var FooterComponent = (function () {
    function FooterComponent() {
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-footer',
            template: __webpack_require__("../../../../../src/app/footer/footer.component.html"),
            styles: [__webpack_require__("../../../../../src/app/footer/footer.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/access-strategy/access-strategy.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Service Access Strategy</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <div>\n      <mat-checkbox [(ngModel)]=\"data.service.accessStrategy.ssoEnabled\">\n        <ng-container i18n=\"services.form.label.sas.ssoEnabled\">\n          {{ messages.services_form_label_sas_ssoEnabled }}\n        </ng-container>\n      </mat-checkbox>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.sas.ssoEnabled\"\n               [matTooltip]=\"messages.services_form_tooltip_sas_ssoEnabled\">help\n      </mat-icon>\n      <mat-checkbox [(ngModel)]=\"data.service.accessStrategy.requireAllAttributes\">\n        <ng-container i18n=\"services.form.label.sas.requireAll\">\n          {{ messages.services_form_label_sas_requireAll }}\n        </ng-container>\n      </mat-checkbox>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.sas.requireAll\"\n               [matTooltip]=\"messages.services_form_tooltip_sas_requireAll\">help\n      </mat-icon>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.sas.unauthorizedredirecturl\"\n               [placeholder]=\"messages.services_form_label_sas_unauthorizedredirecturl\"\n               [(ngModel)]=\"data.service.accessStrategy.unauthorizedRedirectUrl\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.sas.unauthorizedredirecturl\"\n               [matTooltip]=\"messages.services_form_tooltip_sas_unauthorizedredirecturl\">help\n      </mat-icon>\n    </div>\n  </div>\n</mat-card>\n<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Required Attributes</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-rejectedattributes [attributes]=\"data.service.accessStrategy.requiredAttributes\"></app-rejectedattributes>\n    <div>\n      <mat-checkbox [(ngModel)]=\"data.service.accessStrategy.caseInsensitive\">\n        <ng-container i18n=\"services.form.label.sas.caseinsensitive\">\n          {{ messages.services_form_label_sas_caseinsensitive }}\n        </ng-container>\n      </mat-checkbox>\n      <mat-icon style=\"font-size: medium\"\n                i18n-matTooltip=\"services.form.tooltip.sas.unauthorizedredirecturl\"\n                [matTooltip]=\"messages.services_form_tooltip_sas_unauthorizedredirecturl\">help\n      </mat-icon>\n    </div>\n  </div>\n</mat-card>\n\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5>Type</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <div>\n        <mat-form-field class=\"textInput\">\n          <mat-select i18n-placeHolder=\"services.form.label.sas.selecttype\"\n                      [placeholder]=\"messages.services_form_label_sas_selecttype\"\n                     [(ngModel)]=\"type\" (change)=\"changeType()\">\n            <mat-option *ngFor=\"let opt of types\" [value]=\"opt\">{{ TYPE[opt] }}</mat-option>\n          </mat-select>\n        </mat-form-field>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"services.form.tooltip.sas.selecttype\"\n                 [matTooltip]=\"messages.services_form_tooltip_sas_selecttype\">help\n        </mat-icon>\n\n      </div>\n\n      <div *ngIf=\"type == TYPE.REMOTE\">\n        <app-remote></app-remote>\n      </div>\n\n      <div *ngIf=\"type == TYPE.TIME || type == TYPE.GROUPER\">\n        <app-time></app-time>\n      </div>\n\n      <div *ngIf=\"type == TYPE.GROUPER\">\n        <app-grouper></app-grouper>\n      </div>\n\n      <div *ngIf=\"type == TYPE.SURROGATE\">\n        <app-surrogate></app-surrogate>\n      </div>\n\n    </div>\n  </mat-card>\n\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5>Rejected Attributes</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n    <app-rejectedattributes [attributes]=\"data.service.accessStrategy.rejectedAttributes\"></app-rejectedattributes>\n    </div>\n  </mat-card>\n\n\n\n\n"

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/access-strategy.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AccessStrategyComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__ = __webpack_require__("../../../../../src/domain/access-strategy.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__util_util__ = __webpack_require__("../../../../../src/app/util/util.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var Type;
(function (Type) {
    Type[Type["DEFAULT"] = 0] = "DEFAULT";
    Type[Type["TIME"] = 1] = "TIME";
    Type[Type["GROUPER"] = 2] = "GROUPER";
    Type[Type["REMOTE"] = 3] = "REMOTE";
    Type[Type["SURROGATE"] = 4] = "SURROGATE";
})(Type || (Type = {}));
var AccessStrategyComponent = (function () {
    function AccessStrategyComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.TYPE = Type;
        this.types = [Type.DEFAULT, Type.TIME, Type.GROUPER, Type.REMOTE, Type.SURROGATE];
        this.formData = data.formData;
    }
    AccessStrategyComponent.prototype.ngOnInit = function () {
        var service = this.data.service;
        if (__WEBPACK_IMPORTED_MODULE_3__util_util__["a" /* Util */].isEmpty(service.accessStrategy.rejectedAttributes)) {
            service.accessStrategy.rejectedAttributes = new Map();
        }
        if (__WEBPACK_IMPORTED_MODULE_3__util_util__["a" /* Util */].isEmpty(service.accessStrategy.requiredAttributes)) {
            service.accessStrategy.requiredAttributes = new Map();
        }
        this.formData.availableAttributes.forEach(function (item) {
            service.accessStrategy.requiredAttributes[item] = service.accessStrategy.requiredAttributes[item] || [item];
        });
        if (__WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["c" /* RemoteEndpointServiceAccessStrategy */].instanceOf(service.accessStrategy)) {
            this.type = Type.REMOTE;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["e" /* TimeBasedRegisteredServiceAccessStrategy */].instanceOf(service.accessStrategy)) {
            this.type = Type.TIME;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["b" /* GrouperRegisteredServiceAccessStrategy */].instanceOf(service.accessStrategy)) {
            this.type = Type.GROUPER;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["d" /* SurrogateRegisteredServiceAccessStrategy */].instanceOf(service.accessStrategy)) {
            this.type = Type.SURROGATE;
        }
        else {
            this.type = Type.DEFAULT;
        }
    };
    AccessStrategyComponent.prototype.changeType = function () {
        switch (+this.type) {
            case Type.DEFAULT:
                this.data.service.accessStrategy = new __WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["a" /* DefaultRegisteredServiceAccessStrategy */](this.data.service.accessStrategy);
                break;
            case Type.REMOTE:
                this.data.service.accessStrategy = new __WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["c" /* RemoteEndpointServiceAccessStrategy */](this.data.service.accessStrategy);
                break;
            case Type.TIME:
                this.data.service.accessStrategy = new __WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["e" /* TimeBasedRegisteredServiceAccessStrategy */](this.data.service.accessStrategy);
                break;
            case Type.GROUPER:
                this.data.service.accessStrategy = new __WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["b" /* GrouperRegisteredServiceAccessStrategy */](this.data.service.accessStrategy);
                break;
            case Type.SURROGATE:
                this.data.service.accessStrategy = new __WEBPACK_IMPORTED_MODULE_2__domain_access_strategy__["d" /* SurrogateRegisteredServiceAccessStrategy */](this.data.service.accessStrategy);
                break;
            default:
        }
    };
    AccessStrategyComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-access-strategy',
            template: __webpack_require__("../../../../../src/app/form/access-strategy/access-strategy.component.html"),
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_4__data__["a" /* Data */]])
    ], AccessStrategyComponent);
    return AccessStrategyComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/access-strategy/grouper/grouper.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/grouper/grouper.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select required\n             i18n-placeholder=\"services.form.label.sas.grouper.groupfield\"\n             [placeholder]=\"messages.services_form_label_sas_grouper_groupfield\"\n             [(ngModel)]=\"accessStrategy.groupField\">\n      <mat-option *ngFor=\"let opt of data.formData.grouperFields\" [value]=\"opt\">{{ opt }}</mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.label.sas.grouper.groupfield\"\n           [matTooltip]=\"messages.services_form_label_sas_grouper_groupfield\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/grouper/grouper.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return GrouperComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var GrouperComponent = (function () {
    function GrouperComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.groupFields = ['NAME', 'DISPLAY_NAME', 'EXTENSION', 'DISPLAY_EXTENSION'];
        this.accessStrategy = data.service.accessStrategy;
    }
    GrouperComponent.prototype.ngOnInit = function () {
    };
    GrouperComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-grouper',
            template: __webpack_require__("../../../../../src/app/form/access-strategy/grouper/grouper.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/access-strategy/grouper/grouper.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], GrouperComponent);
    return GrouperComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/access-strategy/remote/remote.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/remote/remote.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.sas.remoteUrl\"\n           [placeholder]=\"messages.services_form_label_sas_remoteUrl\"\n           [(ngModel)]=\"accessStrategy.endpointUrl\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.sas.remoteUrl\"\n           [matTooltip]=\"messages.services_form_tooltip_sas_remoteUrl\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput [matAutocomplete]=\"auto\"\n           i18n-placeholder=\"services.form.label.sas.authorizedCodes\"\n           [placeholder]=\"messages.services_form_label_sas_authorizedCodes\"\n           [(ngModel)]=\"accessStrategy.acceptableResponseCodes\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.sas.authorizedCodes\"\n           [matTooltip]=\"messages.services_form_label_sas_authorizedCodes\">help\n  </mat-icon>\n  <mat-autocomplete #auto=\"matAutocomplete\">\n    <mat-option *ngFor=\"let code of data.formData.remoteCodes\" [value]=\"code\">{{ code }}</mat-option>\n  </mat-autocomplete>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/remote/remote.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RemoteComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var RemoteComponent = (function () {
    function RemoteComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.accessStrategy = data.service.accessStrategy;
    }
    RemoteComponent.prototype.ngOnInit = function () {
    };
    RemoteComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-remote',
            template: __webpack_require__("../../../../../src/app/form/access-strategy/remote/remote.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/access-strategy/remote/remote.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], RemoteComponent);
    return RemoteComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/access-strategy/surrogate/surrogate.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".nameWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.valueWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.actionWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 40px;\n          flex: 0 0 40px;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/surrogate/surrogate.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-checkbox [(ngModel)]=\"accessStrategy.surrogateEnabled\">\n    <ng-container i18n=\"services.form.label.sas.surrogate.enabled\">\n      {{ messages.services_form_label_sas_surrogate_enabled }}\n    </ng-container>\n  </mat-checkbox>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.sas.surrogate.enabled\"\n           [matTooltip]=\"messages.services_form_tooltip_sas_surrogate_enabled\">help\n  </mat-icon>\n</div>\n\n<div style=\"padding-top:10px;\">\n  <ng-container i18n=\"services.form.label.sas.surrogate.requiredAttributes\">\n    {{ messages.services_form_label_sas_surrogate_requiredAttributes }}\n  </ng-container>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.sas.surrogate.requiredAttributes\"\n           [matTooltip]=\"messages.services_form_tooltip_sas_surrogate_requiredAttributes\">help\n  </mat-icon>\n  <mat-table [dataSource]=\"dataSource\">\n    <ng-container cdkColumnDef=\"source\">\n      <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'nameWidth'\">Name</mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n        <mat-form-field>\n          <input matInput #text\n                 [ngModel]=\"row.key\"\n                 (change)=\"doChange(row,$event.target.value)\">\n        </mat-form-field>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container cdkColumnDef=\"mapped\">\n      <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'valueWidth'\">Value</mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'valueWidth'\">\n        <mat-form-field>\n          <input matInput\n                 [ngModel]=\"accessStrategy.surrogateRequiredAttributes[row.key]\"\n                 (ngModelChange)=\"accessStrategy.surrogateRequiredAttributes[row.key] = $event.split(',')\">\n        </mat-form-field>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container cdkColumnDef=\"delete\">\n      <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'actionWidth'\"></mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n        <button mat-icon-button (click)=\"delete(row)\"><mat-icon style=\"font-size: medium\">delete</mat-icon></button>\n      </mat-cell>\n    </ng-container>\n\n    <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n    <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n  </mat-table>\n  <div style=\"height:25px;padding-top: 5px;\">\n    <button mat-mini-fab (click)=\"addRow()\" style=\"float:right;\">+</button>\n  </div>\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/surrogate/surrogate.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SurrogateComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__util_util__ = __webpack_require__("../../../../../src/app/util/util.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SurrogateComponent = (function () {
    function SurrogateComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.displayedColumns = ['source', 'mapped', 'delete'];
        this.accessStrategy = data.service.accessStrategy;
    }
    SurrogateComponent.prototype.ngOnInit = function () {
        var rows = [];
        if (__WEBPACK_IMPORTED_MODULE_3__util_util__["a" /* Util */].isEmpty(this.accessStrategy.surrogateRequiredAttributes)) {
            this.accessStrategy.surrogateRequiredAttributes = new Map();
        }
        for (var _i = 0, _a = Array.from(Object.keys(this.accessStrategy.surrogateRequiredAttributes)); _i < _a.length; _i++) {
            var p = _a[_i];
            rows.push(new __WEBPACK_IMPORTED_MODULE_4__row__["a" /* Row */](p));
        }
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_4__row__["b" /* RowDataSource */](rows);
    };
    SurrogateComponent.prototype.addRow = function () {
        this.dataSource.addRow();
    };
    SurrogateComponent.prototype.doChange = function (row, val) {
        this.accessStrategy.surrogateRequiredAttributes[val] = this.accessStrategy.surrogateRequiredAttributes[row.key];
        delete this.accessStrategy.surrogateRequiredAttributes[row.key];
        row.key = val;
    };
    SurrogateComponent.prototype.delete = function (row) {
        delete this.accessStrategy.surrogateRequiredAttributes[row.key];
        this.dataSource.removeRow(row);
    };
    SurrogateComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-surrogate',
            template: __webpack_require__("../../../../../src/app/form/access-strategy/surrogate/surrogate.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/access-strategy/surrogate/surrogate.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], SurrogateComponent);
    return SurrogateComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/access-strategy/time/time.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/time/time.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput [matDatepicker]=\"startPicker\"\n           i18n-placeholder=\"services.form.label.sas.starttime\"\n           [placeholder]=\"messages.services_form_label_sas_starttime\"\n           [(ngModel)]=\"accessStrategy.startingDateTime\">\n    <mat-datepicker-toggle matSuffix [for]=\"startPicker\"></mat-datepicker-toggle>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.sas.starttime\"\n           [matTooltip]=\"messages.services_form_tooltip_sas_starttime\">help\n  </mat-icon>\n  <mat-datepicker #startPicker></mat-datepicker>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput [matDatepicker]=\"endPicker\"\n           i18n-placeholder=\"services.form.label.sas.endtime\"\n           [placeholder]=\"messages.services_form_label_sas_endtime\"\n           [(ngModel)]=\"accessStrategy.endingDateTime\">\n    <mat-datepicker-toggle matSuffix [for]=\"endPicker\"></mat-datepicker-toggle>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.sas.endtime\"\n           [matTooltip]=\"messages.services_form_tooltip_sas_endtime\">help\n  </mat-icon>\n  <mat-datepicker #endPicker></mat-datepicker>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/access-strategy/time/time.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TimeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TimeComponent = (function () {
    function TimeComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.accessStrategy = data.service.accessStrategy;
    }
    TimeComponent.prototype.ngOnInit = function () {
    };
    TimeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-time',
            template: __webpack_require__("../../../../../src/app/form/access-strategy/time/time.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/access-strategy/time/time.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], TimeComponent);
    return TimeComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release-checks/attribute-release-checks.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-checks/attribute-release-checks.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-checkbox [(ngModel)]=\"data.service.attributeReleasePolicy.excludeDefaultAttributes\">\n    <ng-container i18n=\"services.form.label.attrRelease.excludeDefault\">\n      {{ messages.services_form_label_attrRelease_excludeDefault }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.excludeDefault\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_excludeDefault\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"data.service.attributeReleasePolicy.authorizedToReleaseCredentialPassword\">\n    <ng-container i18n=\"services.form.label.attrRelease.releaseCredPassword\">\n      {{ messages.services_form_label_attrRelease_releaseCredPassword }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.releaseCredPassword\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_releaseCredPassword\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"data.service.attributeReleasePolicy.authorizedToReleaseProxyGrantingTicket\">\n    <ng-container i18n=\"services.form.label.attrRelease.releaseProxyTicket\">\n      {{ messages.services_form_label_attrRelease_releaseProxyTicket }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.releaseProxyTicket\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_releaseProxyTicket\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"data.service.attributeReleasePolicy.authorizedToReleaseAuthenticationAttributes\">\n    <ng-container i18n=\"services.form.label.attrRelease.releaseAuthenticationAttributes\">\n      {{ messages.services_form_label_attrRelease_releaseAuthenticationAttributes }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.releaseAuthenticationAttributes\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_releaseAuthenticationAttributes\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-checks/attribute-release-checks.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AttributeReleaseChecksComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AttributeReleaseChecksComponent = (function () {
    function AttributeReleaseChecksComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    AttributeReleaseChecksComponent.prototype.ngOnInit = function () {
    };
    AttributeReleaseChecksComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-attribute-release-checks',
            template: __webpack_require__("../../../../../src/app/form/attribute-release-checks/attribute-release-checks.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/attribute-release-checks/attribute-release-checks.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], AttributeReleaseChecksComponent);
    return AttributeReleaseChecksComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release-consent/attribute-release-consent.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-consent/attribute-release-consent.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-checkbox [(ngModel)]=\"data.service.attributeReleasePolicy.consentPolicy.enabled\">\n    <ng-container i18n=\"services.form.label.attrRelease.constent.enabled\">\n      {{ messages.services_form_label_attrRelease_consent_enabled }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.consent.enabled\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_consent_enabled\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div *ngIf=\"data.service.attributeReleasePolicy.consentPolicy.enabled && !isEmpty( formData.availableAttributes )\">\n  <mat-form-field class=\"textInput\">\n    <mat-select multiple\n                i18n-placeholder=\"services.form.label.attrRelease.consent.excludedAttributes\"\n                [placeholder]=\"messages.services_form_label_attrRelease_consent_excludedAttributes\"\n                [(ngModel)]=\"data.service.attributeReleasePolicy.consentPolicy.excludedAttributes\">\n      <mat-option *ngFor=\"let opt of formData.availableAttributes\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.attrRelease.consent.excludedAttributes\"\n           [matTooltip]=\"messages.services_form_tooltip_attrRelease_consent_excludedAttributes\">help\n  </mat-icon>\n</div>\n\n<div *ngIf=\"data.service.attributeReleasePolicy.consentPolicy.enabled && !isEmpty( formData.availableAttributes )\">\n  <mat-form-field class=\"textInput\">\n    <mat-select multiple\n                i18n-placeholder=\"services.form.label.attrRelease.consent.includeOnlyAttributes\"\n                [placeholder]=\"messages.services_form_label_attrRelease_consent_includeOnlyAttributes\"\n                [(ngModel)]=\"data.service.attributeReleasePolicy.consentPolicy.includeOnlyAttributes\">\n      <mat-option *ngFor=\"let opt of formData.availableAttributes\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.attrRelease.consent.includeOnlyAttributes\"\n           [matTooltip]=\"messages.services_form_tooltip_attrRelease_consent_includeOnlyAttributes\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-consent/attribute-release-consent.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AttributeReleaseConsentComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AttributeReleaseConsentComponent = (function () {
    function AttributeReleaseConsentComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.formData = data.formData;
    }
    AttributeReleaseConsentComponent.prototype.ngOnInit = function () {
    };
    AttributeReleaseConsentComponent.prototype.isEmpty = function (data) {
        return !data || data.length === 0;
    };
    AttributeReleaseConsentComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-attribute-release-consent',
            template: __webpack_require__("../../../../../src/app/form/attribute-release-consent/attribute-release-consent.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/attribute-release-consent/attribute-release-consent.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_1__data__["a" /* Data */]])
    ], AttributeReleaseConsentComponent);
    return AttributeReleaseConsentComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release-filters/attribute-release-filters.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-filters/attribute-release-filters.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-accordion #accordian style=\"width:600px;\" multi=\"true\">\n  <mat-expansion-panel *ngFor=\"let filter of filters();let last=last\" style=\"width:630px;left:-35px;position:relative;\"\n       [expanded]=\"last\">\n    <mat-expansion-panel-header>\n      <mat-panel-title>\n          <button [matMenuTriggerFor]=\"panelMenu\" mat-icon-button (click)=\"selectedFilter = filter;$event.stopPropagation()\" style=\"width:auto;height:auto;line-height: 0px!important;\">\n            <mat-icon style=\"font-size: medium;\">menu</mat-icon></button>\n        <span *ngIf=\"isRegEx(filter)\">Regex</span>\n        <span *ngIf=\"isMappedRegEx(filter)\">Mapped</span>\n        <span *ngIf=\"isReverseMapped(filter)\">Reverse Mapped</span>\n        <span *ngIf=\"isScripted(filter)\">Scripted</span>\n      </mat-panel-title>\n      <mat-panel-description>\n        <span *ngIf=\"isRegEx(filter)\">{{ filter.pattern }}</span>\n        <span *ngIf=\"isMappedRegEx(filter)\">{{ getAttributes(filter) }} </span>\n        <span *ngIf=\"isReverseMapped(filter)\">{{ getAttributes(filter) }}</span>\n        <span *ngIf=\"isScripted(filter)\">{{ filter.script }}</span>\n      </mat-panel-description>\n    </mat-expansion-panel-header>\n    <div *ngIf=\"isRegEx(filter)\">\n      <mat-form-field class=\"textInput\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.attrRelease.attrFilter\"\n               [placeholder]=\"messages.services_form_label_attrRelease_attrFilter\"\n               [(ngModel)]=\"filter.pattern\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.attrRelease.attrFilter\"\n               [matTooltip]=\"messages.services_form_tooltip_attrRelease_attrFilter\">help\n      </mat-icon>\n    </div>\n    <div *ngIf=\"isMappedRegEx(filter) || isReverseMapped(filter)\">\n      <app-mapped [filter]=\"filter\"></app-mapped>\n    </div>\n    <div *ngIf=\"isScripted(filter)\">\n      <mat-form-field class=\"textInput\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.attrRelease.attrFilter.scripted\"\n               [placeholder]=\"messages.services_form_label_attrRelease_attrFilter_scripted\"\n               [(ngModel)]=\"filter.script\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n                i18n-matTooltip=\"services.form.tooltip.attrRelease.attrFilter.scripted\"\n                [matTooltip]=\"messages.services_form_tooltip_attrRelease_attrFilter_scripted\">help\n      </mat-icon>\n    </div>\n  </mat-expansion-panel>\n</mat-accordion>\n<div style=\"height:25px;padding-top: 5px;\">\n  <button mat-mini-fab [matMenuTriggerFor]=\"addMenu\" style=\"float:right;\">+</button>\n</div>\n\n<mat-menu #panelMenu>\n  <button mat-menu-item (click)=\"moveUp()\">Move UP</button>\n  <button mat-menu-item (click)=\"moveDown()\">Move Down</button>\n  <button mat-menu-item (click)=\"removeFilter()\">Remove</button>\n</mat-menu>\n\n<mat-menu #addMenu>\n  <button mat-menu-item (click)=\"addRegEx()\">Regex</button>\n  <button mat-menu-item (click)=\"addMappedRegex()\">Mapped Regex</button>\n  <button mat-menu-item (click)=\"addReverseMapped()\">Reverse Mapped Regex</button>\n  <button mat-menu-item (click)=\"addScript()\">Script</button>\n</mat-menu>\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-filters/attribute-release-filters.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AttributeReleaseFiltersComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__ = __webpack_require__("../../../../../src/domain/attribute-filter.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AttributeReleaseFiltersComponent = (function () {
    function AttributeReleaseFiltersComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    AttributeReleaseFiltersComponent.prototype.ngOnInit = function () {
    };
    AttributeReleaseFiltersComponent.prototype.updateFilter = function (pattern) {
        var attributeFilter = this.data.service.attributeReleasePolicy.attributeFilter;
        if (pattern && pattern !== '') {
            attributeFilter = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["c" /* RegisteredServiceRegexAttributeFilter */]();
            attributeFilter.pattern = pattern;
            this.data.service.attributeReleasePolicy.attributeFilter = attributeFilter;
        }
        else {
            attributeFilter = null;
            this.data.service.attributeReleasePolicy.attributeFilter = null;
        }
    };
    AttributeReleaseFiltersComponent.prototype.getPattern = function () {
        var attributeFilter = this.data.service.attributeReleasePolicy.attributeFilter;
        if (attributeFilter) {
            return attributeFilter.pattern;
        }
        return '';
    };
    AttributeReleaseFiltersComponent.prototype.filters = function () {
        var attributeFilter = this.data.service.attributeReleasePolicy.attributeFilter;
        if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["a" /* RegisteredServiceChainingAttributeFilter */].instanceof(attributeFilter)) {
            return attributeFilter.filters;
        }
        else if (attributeFilter) {
            return [attributeFilter];
        }
        else {
            return [];
        }
    };
    AttributeReleaseFiltersComponent.prototype.addRegEx = function () {
        this.addFilter(new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["c" /* RegisteredServiceRegexAttributeFilter */]());
    };
    AttributeReleaseFiltersComponent.prototype.addMappedRegex = function () {
        this.addFilter(new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["b" /* RegisteredServiceMappedRegexAttributeFilter */]());
    };
    AttributeReleaseFiltersComponent.prototype.addReverseMapped = function () {
        this.addFilter(new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["d" /* RegisteredServiceReverseMappedRegexAttributeFilter */]());
    };
    AttributeReleaseFiltersComponent.prototype.addScript = function () {
        this.addFilter(new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["e" /* RegisteredServiceScriptedAttributeFilter */]());
    };
    AttributeReleaseFiltersComponent.prototype.addFilter = function (filter) {
        var attributeFilter = this.data.service.attributeReleasePolicy.attributeFilter;
        if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["a" /* RegisteredServiceChainingAttributeFilter */].instanceof(attributeFilter)) {
            attributeFilter.filters.push(filter);
        }
        else if (attributeFilter) {
            var chaining = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["a" /* RegisteredServiceChainingAttributeFilter */]();
            chaining.filters.push(attributeFilter);
            chaining.filters.push(filter);
            this.data.service.attributeReleasePolicy.attributeFilter = chaining;
        }
        else {
            this.data.service.attributeReleasePolicy.attributeFilter = filter;
        }
    };
    AttributeReleaseFiltersComponent.prototype.removeFilter = function () {
        if (this.isChaining(this.data.service.attributeReleasePolicy.attributeFilter)) {
            var filters = this.data.service.attributeReleasePolicy.attributeFilter.filters;
            filters.splice(filters.indexOf(this.selectedFilter), 1);
            if (filters.length > 1) {
                return;
            }
            else if (filters.length === 1) {
                this.data.service.attributeReleasePolicy.attributeFilter = filters[0];
                return;
            }
        }
        this.data.service.attributeReleasePolicy.attributeFilter = null;
    };
    AttributeReleaseFiltersComponent.prototype.isRegEx = function (filter) {
        return __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["c" /* RegisteredServiceRegexAttributeFilter */].instanceOf(filter);
    };
    AttributeReleaseFiltersComponent.prototype.isChaining = function (filter) {
        return __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["a" /* RegisteredServiceChainingAttributeFilter */].instanceof(filter);
    };
    AttributeReleaseFiltersComponent.prototype.isMappedRegEx = function (filter) {
        return __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["b" /* RegisteredServiceMappedRegexAttributeFilter */].instanceof(filter);
    };
    AttributeReleaseFiltersComponent.prototype.isReverseMapped = function (filter) {
        return __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["d" /* RegisteredServiceReverseMappedRegexAttributeFilter */].instanceof(filter);
    };
    AttributeReleaseFiltersComponent.prototype.isScripted = function (filter) {
        return __WEBPACK_IMPORTED_MODULE_2__domain_attribute_filter__["e" /* RegisteredServiceScriptedAttributeFilter */].instanceof(filter);
    };
    AttributeReleaseFiltersComponent.prototype.getAttributes = function (filter) {
        return Object.keys(filter.patterns);
    };
    AttributeReleaseFiltersComponent.prototype.moveUp = function () {
        var attributeFilter = this.data.service.attributeReleasePolicy.attributeFilter;
        var i = attributeFilter.filters.indexOf(this.selectedFilter);
        if (i === 0) {
            return;
        }
        attributeFilter.filters[i] = attributeFilter.filters[i - 1];
        attributeFilter.filters[i - 1] = this.selectedFilter;
    };
    AttributeReleaseFiltersComponent.prototype.moveDown = function () {
        var attributeFilter = this.data.service.attributeReleasePolicy.attributeFilter;
        var i = attributeFilter.filters.indexOf(this.selectedFilter);
        if (i === attributeFilter.filters.length - 1) {
            return;
        }
        attributeFilter.filters[i] = attributeFilter.filters[i + 1];
        attributeFilter.filters[i + 1] = this.selectedFilter;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])('accordian'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["u" /* ElementRef */])
    ], AttributeReleaseFiltersComponent.prototype, "accordian", void 0);
    AttributeReleaseFiltersComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-attribute-release-filters',
            template: __webpack_require__("../../../../../src/app/form/attribute-release-filters/attribute-release-filters.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/attribute-release-filters/attribute-release-filters.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], AttributeReleaseFiltersComponent);
    return AttributeReleaseFiltersComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release-filters/mapped/mapped.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".nameWidth {\n    -webkit-box-flex: 0;\n        -ms-flex: 0 0 240px;\n            flex: 0 0 240px;\n}\n\n.valueWidth {\n    -webkit-box-flex: 0;\n        -ms-flex: 0 0 240px;\n            flex: 0 0 240px;\n}\n\n.actionWidth {\n    -webkit-box-flex: 0;\n        -ms-flex: 0 0 40px;\n            flex: 0 0 40px;\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-filters/mapped/mapped.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-table [dataSource]=\"dataSource\">\n\n  <ng-container cdkColumnDef=\"source\">\n    <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'nameWidth'\">Attribute</mat-header-cell>\n    <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n      <mat-form-field>\n        <input matInput #text [matAutocomplete]=\"attributeAuto\"\n               [ngModel]=\"row.key\"\n\n               (ngModelChange)=\"doChange(row,text.value)\">\n      </mat-form-field>\n    </mat-cell>\n  </ng-container>\n\n  <ng-container cdkColumnDef=\"mapped\">\n    <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'valueWidth'\">Filter</mat-header-cell>\n    <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'valueWidth'\">\n      <mat-form-field>\n        <input matInput\n               [(ngModel)]=\"filter.patterns[row.key]\">\n      </mat-form-field>\n    </mat-cell>\n  </ng-container>\n\n  <ng-container cdkColumnDef=\"delete\">\n    <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'actionWidth'\"></mat-header-cell>\n    <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n      <button mat-icon-button (click)=\"delete(row)\"><mat-icon style=\"font-size: medium\">delete</mat-icon></button>\n    </mat-cell>\n  </ng-container>\n\n  <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n  <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n</mat-table>\n<div style=\"height:25px;padding-top: 5px;\">\n  <button mat-mini-fab (click)=\"addRow()\" style=\"float:right;\">+</button>\n</div>\n<div style=\"padding-top: 10px\">\n  <mat-checkbox [(ngModel)]=\"filter.excludeUnmappedAttributes\">\n    <ng-container i18n=\"services.form.label.attrRelease.attrFilter.excludeUnmapped\">\n      {{ messages.services_form_label_attrRelease_attrFilter_excludeUnmapped }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.attrRelease.attrFilter.excludeUnmapped\"\n              [matTooltip]=\"messages.services_form_tooltip_attrRelease_attrFilter_excludeUnmapped\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n<div style=\"padding-bottom: 20px;\">\n  <mat-checkbox [(ngModel)]=\"filter.completeMatch\">\n    <ng-container i18n=\"service.form.label.attrRelease.attrFilter.completeMatch\">\n      {{ messages.services_form_label_attrRelease_attrFilter_completeMatch }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.attrRelease.attrFilter.completeMatch\"\n              [matTooltip]=\"messages.services_form_tooltip_attrRelease_attrFilter_completeMatch\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n<mat-autocomplete #attributeAuto>\n  <mat-option *ngFor=\"let opt of formData.availableAttributes\" [value]=\"opt\">\n    {{ opt }}\n  </mat-option>\n</mat-autocomplete>\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-filters/mapped/mapped.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MappedComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__domain_attribute_filter__ = __webpack_require__("../../../../../src/domain/attribute-filter.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var MappedComponent = (function () {
    function MappedComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.displayedColumns = ['source', 'mapped', 'delete'];
        this.formData = data.formData;
    }
    MappedComponent.prototype.ngOnInit = function () {
        var rows = [];
        if (this.filter.patterns) {
            for (var _i = 0, _a = Array.from(Object.keys(this.filter.patterns)); _i < _a.length; _i++) {
                var p = _a[_i];
                rows.push(new __WEBPACK_IMPORTED_MODULE_4__row__["a" /* Row */](p));
            }
        }
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_4__row__["b" /* RowDataSource */](rows);
    };
    MappedComponent.prototype.addRow = function () {
        this.dataSource.addRow();
    };
    MappedComponent.prototype.doChange = function (row, val) {
        console.log(row.key + ' : ' + val);
        this.filter.patterns[val] = this.filter.patterns[row.key];
        delete this.filter.patterns[row.key];
        row.key = val;
    };
    MappedComponent.prototype.delete = function (row) {
        delete this.filter.patterns[row.key];
        this.dataSource.removeRow(row);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])('filter'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1__domain_attribute_filter__["b" /* RegisteredServiceMappedRegexAttributeFilter */])
    ], MappedComponent.prototype, "filter", void 0);
    MappedComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-mapped',
            template: __webpack_require__("../../../../../src/app/form/attribute-release-filters/mapped/mapped.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/attribute-release-filters/mapped/mapped.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], MappedComponent);
    return MappedComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release-policies/attribute-release-policies.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-policies/attribute-release-policies.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select\n             placeholder=\"Policy\"\n             [(ngModel)]=\"type\"\n             (change)=\"changeType()\">\n      <mat-option *ngFor=\"let opt of types; let i = index\" [value]=\"opt\">\n        {{ display[i] }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n</div>\n\n<div *ngIf=\"type == TYPE.SCRIPT\">\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.attrRelease.policies.scriptFile\"\n           [placeholder]=\"messages.services_form_label_attrRelease_policies_scriptFile\"\n           [(ngModel)]=\"data.service.attributeReleasePolicy.scriptFile\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.attrRelease.policies.scriptFile\"\n           [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_scriptFile\">help\n  </mat-icon>\n</div>\n\n<div *ngIf=\"type == TYPE.GROOVY\">\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.attrRelease.policies.scriptFile\"\n           [placeholder]=\"messages.services_form_label_attrRelease_policies_scriptFile\"\n           [(ngModel)]=\"data.service.attributeReleasePolicy.groovyScript\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.attrRelease.policies.scriptFile\"\n           [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_scriptFile\">help\n  </mat-icon>\n</div>\n\n<div *ngIf=\"(type == TYPE.RETURN_ALLOWED || type == TYPE.METADATA) && !isEmpty( formData.availableAttributes )\">\n  <mat-form-field class=\"textInput\">\n    <mat-select multiple\n                i18n-placeholder=\"services.form.label.attrRelease.policies.returnAllowed\"\n                [placeholder]=\"messages.services_form_label_attrRelease_policies_returnAllowed\"\n                [(ngModel)]=\"data.service.attributeReleasePolicy.allowedAttributes\">\n      <mat-option *ngFor=\"let opt of formData.availableAttributes\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.attrRelease.policies.returnAllowed\"\n           [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_returnAllowed\">help\n  </mat-icon>\n</div>\n\n<div *ngIf=\"type == TYPE.RETURN_MAPPED && !isEmpty( formData.availableAttributes )\">\n  <app-mappedattributes [attributes]=\"data.service.attributeReleasePolicy.allowedAttributes\"></app-mappedattributes>\n</div>\n\n<div *ngIf=\"type == TYPE.METADATA\" style=\"padding-top:25px;\">\n  <div>\n    <mat-form-field class=\"textInput\">\n      <input matInput\n             i18n-placeholder=\"services.form.label.attrRelease.entityAttribute\"\n             [placeholder]=\"messages.services_form_label_attrRelease_entityAttribute\"\n             [(ngModel)]=\"data.service.attributeReleasePolicy.entityAttribute\">\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.entityAttribute\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_entityAttribute\">help\n    </mat-icon>\n  </div>\n\n  <div>\n    <mat-form-field class=\"textInput\">\n      <input matInput\n             i18n-placeholder=\"services.form.label.attrRelease.entityAttributeFormat\"\n             [placeholder]=\"messages.services_form_label_attrRelease_entityAttributeFormat\"\n             [(ngModel)]=\"data.service.attributeReleasePolicy.entityAttributeFormat\">\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.entityAttributeFormat\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_entityAttributeFormat\">help\n    </mat-icon>\n  </div>\n\n  <div>\n    <mat-form-field class=\"textInput\">\n      <input matInput\n             i18n-placeholder=\"services.form.label.attrRelease.entityAttributeValues\"\n             [placeholder]=\"messages.services_form_label_attrRelease_entityAttributeValues\"\n             [ngModel]=\"data.service.attributeReleasePolicy.entityAttributeValues\"\n             (ngModelChange)=\"data.service.attributeReleasePolicy.entityAttributeValues = $event.split(',')\">\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.entityAttribute\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_entityAttributeValues\">help\n    </mat-icon>\n  </div>\n\n</div>\n\n<div *ngIf=\"type == TYPE.RESTFUL\">\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.attrRelease.policies.restful\"\n           [placeholder]=\"messages.services_form_label_attrRelease_policies_restful\"\n           [(ngModel)]=\"data.service.attributeReleasePolicy.endpoint\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.attrRelease.policies.restful\"\n            [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_restful\">help\n  </mat-icon>\n</div>\n\n<div *ngIf=\"type == TYPE.GROOVY_SAML\">\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.attrRelease.policies.groovySaml\"\n           [placeholder]=\"messages.services_form_label_attrRelease_policies_groovySaml\"\n           [(ngModel)]=\"data.service.attributeReleasePolicy.groovyScript\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.attrRelease.policies.groovySaml\"\n            [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_groovySaml\">help\n  </mat-icon>\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-policies/attribute-release-policies.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AttributeReleasePoliciesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__ = __webpack_require__("../../../../../src/domain/attribute-release.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domain_saml_service__ = __webpack_require__("../../../../../src/domain/saml-service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var Type;
(function (Type) {
    Type[Type["RETURN_ALL"] = 0] = "RETURN_ALL";
    Type[Type["DENY_ALL"] = 1] = "DENY_ALL";
    Type[Type["RETURN_MAPPED"] = 2] = "RETURN_MAPPED";
    Type[Type["RETURN_ALLOWED"] = 3] = "RETURN_ALLOWED";
    Type[Type["SCRIPT"] = 4] = "SCRIPT";
    Type[Type["GROOVY"] = 5] = "GROOVY";
    Type[Type["INCOMMON"] = 6] = "INCOMMON";
    Type[Type["MATCHING"] = 7] = "MATCHING";
    Type[Type["METADATA"] = 8] = "METADATA";
    Type[Type["RESTFUL"] = 9] = "RESTFUL";
    Type[Type["GROOVY_SAML"] = 10] = "GROOVY_SAML";
})(Type || (Type = {}));
var AttributeReleasePoliciesComponent = (function () {
    function AttributeReleasePoliciesComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.TYPE = Type;
        this.types = [Type.SCRIPT, Type.GROOVY, Type.RETURN_ALL, Type.DENY_ALL, Type.RETURN_ALLOWED, Type.RETURN_MAPPED, Type.RESTFUL];
        this.display = ['Script Engine', 'Groovy Script', 'Return All', 'Deny All', 'Return Allowed', 'Return Mapped', 'Return Restful'];
        this.formData = data.formData;
    }
    AttributeReleasePoliciesComponent.prototype.ngOnInit = function () {
        if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["g" /* ReturnAllAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.RETURN_ALL;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["a" /* DenyAllAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.DENY_ALL;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["i" /* ReturnMappedAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            var mapped_1 = this.data.service.attributeReleasePolicy;
            this.formData.availableAttributes.forEach(function (item) {
                mapped_1.allowedAttributes[item] = mapped_1.allowedAttributes[item] || [item];
            });
            this.type = Type.RETURN_MAPPED;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["h" /* ReturnAllowedAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.RETURN_ALLOWED;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["k" /* ScriptedRegisteredServiceAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.SCRIPT;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["c" /* GroovyScriptAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.GROOVY;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["d" /* InCommonRSAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.INCOMMON;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["f" /* PatternMatchingEntityIdAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.MATCHING;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["e" /* MetadataEntityAttributesAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.METADATA;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["j" /* ReturnRestfulAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.RESTFUL;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["b" /* GroovySamlRegisteredServiceAttributeReleasePolicy */].instanceOf(this.data.service.attributeReleasePolicy)) {
            this.type = Type.GROOVY_SAML;
        }
        this.isSaml = __WEBPACK_IMPORTED_MODULE_4__domain_saml_service__["a" /* SamlRegisteredService */].instanceOf(this.data.service);
        if (this.isSaml && this.types.indexOf(Type.INCOMMON) < 0) {
            this.types.push(Type.INCOMMON);
            this.display.push('InCommon');
            this.types.push(Type.MATCHING);
            this.display.push('Matching');
            this.types.push(Type.METADATA);
            this.display.push('Metadata Entity Attributes');
            this.types.push((Type.GROOVY_SAML));
            this.display.push('Groovy SAML Script');
        }
        else if (!this.isSaml && this.types.indexOf(Type.INCOMMON) > -1) {
            this.types.splice(this.types.indexOf(Type.INCOMMON), 1);
            this.display.splice(this.display.indexOf('InCommon'), 1);
            this.types.splice(this.types.indexOf(Type.MATCHING), 1);
            this.display.splice(this.display.indexOf('Matching'), 1);
            this.types.splice(this.types.indexOf(Type.METADATA), 1);
            this.display.splice(this.display.indexOf('Metadata Entity Attributes'), 1);
            this.types.splice(this.types.indexOf(Type.GROOVY_SAML), 1);
            this.display.splice(this.display.indexOf('Groovy SAML Script'), 1);
        }
    };
    AttributeReleasePoliciesComponent.prototype.changeType = function () {
        switch (+this.type) {
            case Type.RETURN_ALL:
                console.log('Changed to return all');
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["g" /* ReturnAllAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.DENY_ALL:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["a" /* DenyAllAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.RETURN_MAPPED:
                var mapped_2 = this.data.service.attributeReleasePolicy;
                mapped_2.allowedAttributes = new Map();
                this.formData.availableAttributes.forEach(function (item) {
                    mapped_2.allowedAttributes[item] = [item];
                });
                this.data.service.attributeReleasePolicy = mapped_2;
                break;
            case Type.RETURN_ALLOWED:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["g" /* ReturnAllAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.SCRIPT:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["k" /* ScriptedRegisteredServiceAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.GROOVY:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["c" /* GroovyScriptAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.INCOMMON:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["d" /* InCommonRSAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.MATCHING:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["f" /* PatternMatchingEntityIdAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.METADATA:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["e" /* MetadataEntityAttributesAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.RESTFUL:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["j" /* ReturnRestfulAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
            case Type.GROOVY_SAML:
                this.data.service.attributeReleasePolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_release__["b" /* GroovySamlRegisteredServiceAttributeReleasePolicy */](this.data.service.attributeReleasePolicy);
                break;
        }
    };
    AttributeReleasePoliciesComponent.prototype.isEmpty = function (data) {
        return !data || data.length === 0;
    };
    AttributeReleasePoliciesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-attribute-release-policies',
            template: __webpack_require__("../../../../../src/app/form/attribute-release-policies/attribute-release-policies.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/attribute-release-policies/attribute-release-policies.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], AttributeReleasePoliciesComponent);
    return AttributeReleasePoliciesComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release-principal-repo/attribute-release-principal-repo.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-principal-repo/attribute-release-principal-repo.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-radio-group [(ngModel)]=\"type\" (change)=\"changeType()\">\n\n    <mat-radio-button [value]=\"TYPE.DEFAULT\">\n      <ng-container i18n=\"services.form.label.attrRelease.principleAttRepo.default\">\n        {{ messages.services_form_label_attrRelease_principleAttRepo_default }}\n      </ng-container>\n    </mat-radio-button>\n\n    <mat-radio-button [value]=\"TYPE.CACHING\">\n      <ng-container i18n=\"services.form.label.attrRelease.principleAttRepo.cached\">\n        {{ messages.services_form_label_attrRelease_principleAttRepo_cached }}\n      </ng-container>\n    </mat-radio-button>\n\n  </mat-radio-group>\n</div>\n\n<div *ngIf=\"type == TYPE.CACHING\">\n  <div>\n    <mat-form-field class=\"textInput\">\n      <mat-select required\n                  i18n-placeholder=\"services.form.label.attrRelease.principleAttRepo.cached.timeUnit\"\n                  [placeholder]=\"messages.services_form_label_attrRelease_principleAttRepo_cached_timeUnit\"\n                  [(ngModel)]=\"data.service.attributeReleasePolicy.principalAttributesRepository.timeUnit\">\n        <mat-option *ngFor=\"let opt of formData.timeUnits\" [value]=\"opt\">\n          {{ opt }}\n        </mat-option>\n      </mat-select>\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.principleAttRepo.cached.timeUnit\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_principleAttRepo_cached_timeUnit\">help\n    </mat-icon>\n  </div>\n\n  <div>\n    <mat-form-field class=\"textInput\">\n      <input matInput\n             i18n-placeholder=\"services.form.label.attrRelease.principleAttRepo.cached.expiration\"\n             [placeholder]=\"messages.services_form_label_attrRelease_principleAttRepo_cached_expiration\"\n             [(ngModel)]=\"data.service.attributeReleasePolicy.principalAttributesRepository.expiration\">\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.principleAttRepo.cached.expiration\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_principleAttRepo_cached_expiration\">help\n    </mat-icon>\n  </div>\n\n  <div>\n    <mat-form-field class=\"textInput\">\n      <mat-select required\n                  i18n-placeholder=\"services.form.label.attrRelease.principleAttRepo.cached.mergeStrategy\"\n                  [placeholder]=\"messages.services_form_label_attrRelease_principleAttRepo_cached_mergeStrategy\"\n                  [(ngModel)]=\"data.service.attributeReleasePolicy.principalAttributesRepository.mergingStrategy\">\n        <mat-option *ngFor=\"let opt of formData.mergingStrategies\" [value]=\"opt\">\n          {{ opt }}\n        </mat-option>\n      </mat-select>\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.attrRelease.principleAttRepo.cached.mergeStrategy\"\n             [matTooltip]=\"messages.services_form_tooltip_attrRelease_principleAttRepo_cached_mergeStrategy\">help\n    </mat-icon>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release-principal-repo/attribute-release-principal-repo.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AttributeReleasePrincipalRepoComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_attribute_repo__ = __webpack_require__("../../../../../src/domain/attribute-repo.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var Type;
(function (Type) {
    Type[Type["DEFAULT"] = 0] = "DEFAULT";
    Type[Type["CACHING"] = 1] = "CACHING";
})(Type || (Type = {}));
var AttributeReleasePrincipalRepoComponent = (function () {
    function AttributeReleasePrincipalRepoComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.TYPE = Type;
        this.formData = data.formData;
    }
    AttributeReleasePrincipalRepoComponent.prototype.ngOnInit = function () {
        if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_repo__["b" /* DefaultPrincipalAttributesRepository */].instanceOf(this.data.service.attributeReleasePolicy.principalAttributesRepository)) {
            this.type = Type.DEFAULT;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_repo__["a" /* CachingPrincipalAttributesRepository */].instanceOf(this.data.service.attributeReleasePolicy.principalAttributesRepository)) {
            this.type = Type.CACHING;
        }
    };
    AttributeReleasePrincipalRepoComponent.prototype.changeType = function () {
        switch (+this.type) {
            case Type.DEFAULT:
                this.data.service.attributeReleasePolicy.principalAttributesRepository = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_repo__["b" /* DefaultPrincipalAttributesRepository */]();
                break;
            case Type.CACHING:
                this.data.service.attributeReleasePolicy.principalAttributesRepository = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_repo__["a" /* CachingPrincipalAttributesRepository */]();
                break;
        }
    };
    AttributeReleasePrincipalRepoComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-attribute-release-principal-repo',
            template: __webpack_require__("../../../../../src/app/form/attribute-release-principal-repo/attribute-release-principal-repo.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/attribute-release-principal-repo/attribute-release-principal-repo.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], AttributeReleasePrincipalRepoComponent);
    return AttributeReleasePrincipalRepoComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/attribute-release/attribute-release.component.html":
/***/ (function(module, exports) {

module.exports = "\n\n<div *ngIf=\"!isOidc && !isWsFed\">\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5 i18n>Attribute Release Policy</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <app-attribute-release-policies></app-attribute-release-policies>\n    </div>\n  </mat-card>\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5 i18n>Attribute Release Options</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <app-attribute-release-checks></app-attribute-release-checks>\n    </div>\n  </mat-card>\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5 i18n>Attribute Release Consent</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <app-attribute-release-consent></app-attribute-release-consent>\n    </div>\n  </mat-card>\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5 i18n>Atrribute Value Filters</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <app-attribute-release-filters></app-attribute-release-filters>\n    </div>\n  </mat-card>\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5>Principal Attribute Repository</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <app-attribute-release-principal-repo></app-attribute-release-principal-repo>\n    </div>\n  </mat-card>\n</div>\n\n\n<div *ngIf=\"isOidc\">\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5 i18n>Attribute Release Options</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <div>\n        <mat-form-field class=\"textInput\">\n          <mat-select multiple\n                      i18n-placeholder=\"services.form.label.oidc.scopes\"\n                      [placeholder]=\"messages.services_form_label_oidc_scopes\"\n                      [(ngModel)]=\"oidcService.scopes\">\n            <mat-option *ngFor=\"let opt of data.formData.oidcScopes\" [value]=\"opt.value\">{{ opt.display }}</mat-option>\n          </mat-select>\n        </mat-form-field>\n        <mat-icon style=\"font-size: medium\"\n                  i18n-matTooltip=\"services.form.tooltip.oidc.scopes\"\n                  [matTooltip]=\"messages.services_form_tooltip_oidc_scopes\">help\n        </mat-icon>\n      </div>\n    </div>\n  </mat-card>\n</div>\n\n<div *ngIf=\"isWsFed\">\n  <mat-card class=\"tabCard\">\n    <mat-card-title>\n      <h5 i18n>Attribute Release Options</h5>\n    </mat-card-title>\n    <div class=\"cardContent\">\n      <app-attribute-release-principal-repo></app-attribute-release-principal-repo>\n      <app-wsfedattrrelpolicies></app-wsfedattrrelpolicies>\n    </div>\n  </mat-card>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/attribute-release/attribute-release.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AttributeReleaseComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__ = __webpack_require__("../../../../../src/domain/oauth-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domain_wsed_service__ = __webpack_require__("../../../../../src/domain/wsed-service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AttributeReleaseComponent = (function () {
    function AttributeReleaseComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    AttributeReleaseComponent.prototype.ngOnInit = function () {
        this.isOidc = __WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__["b" /* OidcRegisteredService */].instanceOf(this.data.service);
        this.isWsFed = __WEBPACK_IMPORTED_MODULE_4__domain_wsed_service__["a" /* WSFederationRegisterdService */].instanceOf(this.data.service);
        if (this.isOidc) {
            this.oidcService = this.data.service;
        }
    };
    AttributeReleaseComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-attribute-release',
            template: __webpack_require__("../../../../../src/app/form/attribute-release/attribute-release.component.html"),
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], AttributeReleaseComponent);
    return AttributeReleaseComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/contacts/contacts.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/contacts/contacts.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-tab-group [(selectedIndex)]=\"selectedTab\">\n    <mat-tab *ngFor=\"let contact of data.service.contacts;let i = index;\" [label]=\"getTabHeader(contact)\">\n      <div>\n        <mat-form-field class=\"textInput\">\n          <input matInput required\n                 placeholder=\"Name\" name=\"name\" id=\"name\"\n                 [(ngModel)]=\"contact.name\">\n        </mat-form-field>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"contact.name\"\n                 matTooltip=\"First and last name of the contact\">help\n        </mat-icon>\n      </div>\n      <div>\n        <mat-form-field class=\"textInput\">\n          <input matInput required\n                 placeholder=\"Email\"\n                 [(ngModel)]=\"contact.email\">\n        </mat-form-field>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"contact.email\"\n                 matTooltip=\"EMail of the contact\">help\n        </mat-icon>\n      </div>\n      <div>\n        <mat-form-field class=\"textInput\">\n          <input matInput\n                 placeholder=\"Phone\"\n                 [(ngModel)]=\"contact.phone\">\n        </mat-form-field>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"contact.phone\"\n                 matTooltip=\"Phone number of the contact\">help\n        </mat-icon>\n      </div>\n      <div>\n        <mat-form-field class=\"textInput\">\n          <input matInput\n                 placeholder=\"Department\"\n                 [(ngModel)]=\"contact.department\">\n        </mat-form-field>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"contact.department\"\n                 matTooltip=\"Department of the contact\">help\n        </mat-icon>\n      </div>\n    </mat-tab>\n  </mat-tab-group>\n  <div style=\"height:25px;padding-top: 5px;\">\n    <div style=\"float:right;padidng:5px\">\n      <button mat-mini-fab (click)=\"addContact()\">\n        <mat-icon>add</mat-icon>\n      </button>\n      <button mat-mini-fab (click)=\"deleteContact()\">\n        <mat-icon>delete</mat-icon>\n      </button>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/contacts/contacts.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ContactsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__domain_contact__ = __webpack_require__("../../../../../src/domain/contact.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ContactsComponent = (function () {
    function ContactsComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ContactsComponent.prototype.ngOnInit = function () {
        if (!this.data.service.contacts) {
            this.data.service.contacts = [];
        }
    };
    ContactsComponent.prototype.addContact = function () {
        var _this = this;
        this.data.service.contacts.push(new __WEBPACK_IMPORTED_MODULE_3__domain_contact__["a" /* DefaultRegisteredServiceContact */]());
        this.selectedTab = this.data.service.contacts.length - 1;
        setTimeout(function () {
            _this.form.resetForm();
        }, 100);
    };
    ContactsComponent.prototype.deleteContact = function () {
        if (this.selectedTab > -1) {
            this.data.service.contacts.splice(this.selectedTab, 1);
        }
    };
    ContactsComponent.prototype.getTabHeader = function (contact) {
        return contact.name ? contact.name : this.data.service.contacts.indexOf(contact) + 1;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_4__angular_forms__["g" /* NgForm */])
    ], ContactsComponent.prototype, "form", void 0);
    ContactsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-contacts',
            template: __webpack_require__("../../../../../src/app/form/contacts/contacts.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/contacts/contacts.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_1__data__["a" /* Data */]])
    ], ContactsComponent);
    return ContactsComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/data.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Data; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__domain_form_data__ = __webpack_require__("../../../../../src/domain/form-data.ts");
/**
 * Created by tschmidt on 2/22/17.
 */
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var Data = (function () {
    function Data() {
        this.formData = new __WEBPACK_IMPORTED_MODULE_1__domain_form_data__["a" /* FormData */]();
        this.save = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["x" /* EventEmitter */]();
    }
    Data = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])()
    ], Data);
    return Data;
}());



/***/ }),

/***/ "../../../../../src/app/form/enabled/enabled.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"padding-bottom: 10px;\">\n  <mat-checkbox [(ngModel)]=\"data.service.accessStrategy.enabled\">\n    <ng-container i18n=\"services.form.label.sas.casEnabled\">\n      {{ messages.services_form_label_sas_casEnabled }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.sas.casEnabled\"\n             [matTooltip]=\"messages.services_form_tooltip_sas_casEnabled\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/enabled/enabled.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EnabledComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var EnabledComponent = (function () {
    function EnabledComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    EnabledComponent.prototype.ngOnInit = function () {
    };
    EnabledComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-enabled',
            template: __webpack_require__("../../../../../src/app/form/enabled/enabled.component.html"),
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], EnabledComponent);
    return EnabledComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/evalorder/evalorder.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.evalOrder\"\n           [placeholder]=\"messages.services_form_label_evalOrder\"\n           [(ngModel)]=\"data.service.evaluationOrder\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.evalOrder\"\n           [matTooltip]=\"messages.services_form_tooltip_evalOrder\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/evalorder/evalorder.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EvalorderComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var EvalorderComponent = (function () {
    function EvalorderComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    EvalorderComponent.prototype.ngOnInit = function () {
    };
    EvalorderComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-evalorder',
            template: __webpack_require__("../../../../../src/app/form/evalorder/evalorder.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], EvalorderComponent);
    return EvalorderComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/expiration/expiration.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/expiration/expiration.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.expirationPolicy.expirationDate\"\n           [placeholder]=\"messages.services_form_label_expirationPolicy_expirationDate\"\n           [(ngModel)]=\"data.service.expirationPolicy.expirationDate\">\n  </mat-form-field>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.expirationPolicy.expirationDate\"\n              [matTooltip]=\"messages.services_form_tooltip_expirationPolicy_expirationDate\">help\n    </mat-icon>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"data.service.expirationPolicy.deleteWhenExpired\">\n    <ng-container i18n=\"services.form.label.expirationPolicy.deleteWhenExpired\">\n      {{ messages.services_form_label_expirationPolicy_deleteWhenExpired }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.expirationPolicy.deleteWhenExpired\"\n              [matTooltip]=\"messages.services_form_tooltip_expirationPolicy_deleteWhenExpired\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"data.service.expirationPolicy.notifyWhenDeleted\">\n    <ng-container i18n=\"services.form.label.expirationPolicy.notifyWhenDeleted\">\n      {{ messages.services_form_label_expirationPolicy_notifyWhenDeleted }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.expirationPolicy.notifyWhenDeleted\"\n              [matTooltip]=\"messages.services_form_tooltip_expirationPolicy_notifyWhenDeleted\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>"

/***/ }),

/***/ "../../../../../src/app/form/expiration/expiration.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ExpirationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ExpirationComponent = (function () {
    function ExpirationComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ExpirationComponent.prototype.ngOnInit = function () {
    };
    ExpirationComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-expiration',
            template: __webpack_require__("../../../../../src/app/form/expiration/expiration.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/expiration/expiration.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], ExpirationComponent);
    return ExpirationComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/form-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__form_component__ = __webpack_require__("../../../../../src/app/form/form.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__form_resolover__ = __webpack_require__("../../../../../src/app/form/form.resolover.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__tab_basics_tab_basics_component__ = __webpack_require__("../../../../../src/app/form/tab-basics/tab-basics.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__tab_logout_tab_logout_component__ = __webpack_require__("../../../../../src/app/form/tab-logout/tab-logout.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__tab_accessstrategy_tab_accessstrategy_component__ = __webpack_require__("../../../../../src/app/form/tab-accessstrategy/tab-accessstrategy.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__tab_mulitauth_tab_mulitauth_component__ = __webpack_require__("../../../../../src/app/form/tab-mulitauth/tab-mulitauth.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__tab_proxy_tab_proxy_component__ = __webpack_require__("../../../../../src/app/form/tab-proxy/tab-proxy.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__tab_usernameattr_tab_usernameattr_component__ = __webpack_require__("../../../../../src/app/form/tab-usernameattr/tab-usernameattr.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__tab_attrrelease_tab_attrrelease_component__ = __webpack_require__("../../../../../src/app/form/tab-attrrelease/tab-attrrelease.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__tab_properties_tab_properties_component__ = __webpack_require__("../../../../../src/app/form/tab-properties/tab-properties.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__tab_advanced_tab_advanced_component__ = __webpack_require__("../../../../../src/app/form/tab-advanced/tab-advanced.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__tab_saml_tab_saml_component__ = __webpack_require__("../../../../../src/app/form/tab-saml/tab-saml.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__tab_oauth_tab_oauth_component__ = __webpack_require__("../../../../../src/app/form/tab-oauth/tab-oauth.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__tab_wsfed_tab_wsfed_component__ = __webpack_require__("../../../../../src/app/form/tab-wsfed/tab-wsfed.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__tab_contacts_tab_contacts_component__ = __webpack_require__("../../../../../src/app/form/tab-contacts/tab-contacts.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__tab_expiration_tab_expiration_component__ = __webpack_require__("../../../../../src/app/form/tab-expiration/tab-expiration.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__tab_oidc_tab_oidc_component__ = __webpack_require__("../../../../../src/app/form/tab-oidc/tab-oidc.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by tschmidt on 2/23/17.
 */



















var childRoutes = [
    {
        path: 'basics',
        component: __WEBPACK_IMPORTED_MODULE_4__tab_basics_tab_basics_component__["a" /* TabBasicsComponent */],
        outlet: 'form'
    },
    {
        path: 'saml',
        component: __WEBPACK_IMPORTED_MODULE_13__tab_saml_tab_saml_component__["a" /* TabSamlComponent */],
        outlet: 'form'
    },
    {
        path: 'oauth',
        component: __WEBPACK_IMPORTED_MODULE_14__tab_oauth_tab_oauth_component__["a" /* TabOauthComponent */],
        outlet: 'form'
    },
    {
        path: 'oidc',
        component: __WEBPACK_IMPORTED_MODULE_18__tab_oidc_tab_oidc_component__["a" /* TabOIDCComponent */],
        outlet: 'form'
    },
    {
        path: 'wsfed',
        component: __WEBPACK_IMPORTED_MODULE_15__tab_wsfed_tab_wsfed_component__["a" /* TabWsfedComponent */],
        outlet: 'form'
    },
    {
        path: 'contacts',
        component: __WEBPACK_IMPORTED_MODULE_16__tab_contacts_tab_contacts_component__["a" /* TabContactsComponent */],
        outlet: 'form'
    },
    {
        path: 'logout',
        component: __WEBPACK_IMPORTED_MODULE_5__tab_logout_tab_logout_component__["a" /* TabLogoutComponent */],
        outlet: 'form'
    },
    {
        path: 'accessstrategy',
        component: __WEBPACK_IMPORTED_MODULE_6__tab_accessstrategy_tab_accessstrategy_component__["a" /* TabAccessstrategyComponent */],
        outlet: 'form'
    },
    {
        path: 'expiration',
        component: __WEBPACK_IMPORTED_MODULE_17__tab_expiration_tab_expiration_component__["a" /* TabExpirationComponent */],
        outlet: 'form'
    },
    {
        path: 'multiauth',
        component: __WEBPACK_IMPORTED_MODULE_7__tab_mulitauth_tab_mulitauth_component__["a" /* TabMulitauthComponent */],
        outlet: 'form'
    },
    {
        path: 'proxy',
        component: __WEBPACK_IMPORTED_MODULE_8__tab_proxy_tab_proxy_component__["a" /* TabProxyComponent */],
        outlet: 'form'
    },
    {
        path: 'userattr',
        component: __WEBPACK_IMPORTED_MODULE_9__tab_usernameattr_tab_usernameattr_component__["a" /* TabUsernameattrComponent */],
        outlet: 'form'
    },
    {
        path: 'attrRelease',
        component: __WEBPACK_IMPORTED_MODULE_10__tab_attrrelease_tab_attrrelease_component__["a" /* TabAttrreleaseComponent */],
        outlet: 'form'
    },
    {
        path: 'properties',
        component: __WEBPACK_IMPORTED_MODULE_11__tab_properties_tab_properties_component__["a" /* TabPropertiesComponent */],
        outlet: 'form'
    },
    {
        path: 'advanced',
        component: __WEBPACK_IMPORTED_MODULE_12__tab_advanced_tab_advanced_component__["a" /* TabAdvancedComponent */],
        outlet: 'form'
    }
];
var FormRoutingModule = (function () {
    function FormRoutingModule() {
    }
    FormRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */].forChild([
                    {
                        path: 'duplicate/:id',
                        component: __WEBPACK_IMPORTED_MODULE_2__form_component__["a" /* FormComponent */],
                        resolve: {
                            resp: __WEBPACK_IMPORTED_MODULE_3__form_resolover__["a" /* FormResolve */]
                        },
                        children: childRoutes,
                        data: {
                            duplicate: true,
                        }
                    },
                    {
                        path: 'form/:id',
                        component: __WEBPACK_IMPORTED_MODULE_2__form_component__["a" /* FormComponent */],
                        resolve: {
                            resp: __WEBPACK_IMPORTED_MODULE_3__form_resolover__["a" /* FormResolve */]
                        },
                        children: childRoutes
                    }
                ])
            ],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */]]
        })
    ], FormRoutingModule);
    return FormRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app/form/form.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/deep/ .mat-tooltip {\n    font-size: 12px !important;\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/form.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"position:fixed;width: 100%; z-index: 1000;background-color: #f2f2f2; top: 51px\" autocomplete=\"off\" novalidate=\"novalidate\">\n\n  <div style=\"display:flex;\">\n    <div style=\"padding-top: 3px;\">\n      <mat-icon style=\"padding-top: 3px;\">add_circle</mat-icon>\n      <h4 style=\"display: inline;position: relative;top: -5px;\">\n        <ng-container i18n=\"services.form.header.page.editService\">\n          {{ messages.services_form_header_page_editService }}\n        </ng-container>\n      </h4>\n    </div>\n    <div style=\"flex: 1 1 auto\"></div>\n    <div>\n      <app-controls (save)=\"save()\"></app-controls>\n    </div>\n  </div>\n\n  <mat-tab-group #tabGroup (selectedIndexChange)=\"goto($event)\">\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Basics</ng-container>\n      </ng-template>\n    </mat-tab>\n    <!--\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Service Type</ng-container>\n      </ng-template>\n    </mat-tab>\n    -->\n    <mat-tab *ngIf=\"isSaml() || isOauth() || isOidc() || isWsFed()\">\n      <ng-template mat-tab-label>\n        <ng-container *ngIf=\"isSaml()\" i18n>SAML2 SP</ng-container>\n        <ng-container i18n *ngIf=\"isOauth()\">OAuth2</ng-container>\n        <ng-container *ngIf=\"isOidc()\" i18n>OpenID Connect</ng-container>\n        <ng-container *ngIf=\"isWsFed()\" i18n>WS Federation</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n        <ng-container i18n>Contacts</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Logout</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Access Strategy</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n        <ng-container i18n>Expiration</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Multifactor Authentication</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Proxy Authentication</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Username Attribute</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Attribute Release</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container i18n>Properties</ng-container>\n      </ng-template>\n    </mat-tab>\n    <mat-tab>\n      <ng-template mat-tab-label>\n          <ng-container>Advanced</ng-container>\n      </ng-template>\n    </mat-tab>\n  </mat-tab-group>\n</div>\n<div style=\"position:relative;top:90px;margin-bottom:75px;\">\n  <router-outlet name=\"form\"></router-outlet>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/form.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__form_service__ = __webpack_require__("../../../../../src/app/form/form.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__domain_registered_service__ = __webpack_require__("../../../../../src/domain/registered-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__domain_attribute_repo__ = __webpack_require__("../../../../../src/domain/attribute-repo.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__domain_attribute_provider__ = __webpack_require__("../../../../../src/domain/attribute-provider.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__domain_proxy_policy_ts__ = __webpack_require__("../../../../../src/domain/proxy-policy,ts.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__domain_oauth_service__ = __webpack_require__("../../../../../src/domain/oauth-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__domain_saml_service__ = __webpack_require__("../../../../../src/domain/saml-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__domain_wsed_service__ = __webpack_require__("../../../../../src/domain/wsed-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__domain_access_strategy__ = __webpack_require__("../../../../../src/domain/access-strategy.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};















var Tabs;
(function (Tabs) {
    Tabs[Tabs["BASICS"] = 0] = "BASICS";
    Tabs[Tabs["TYPE"] = 1] = "TYPE";
    Tabs[Tabs["CONTACTS"] = 2] = "CONTACTS";
    Tabs[Tabs["LOGOUT"] = 3] = "LOGOUT";
    Tabs[Tabs["ACCESS_STRATEGY"] = 4] = "ACCESS_STRATEGY";
    Tabs[Tabs["EXPIRATION"] = 5] = "EXPIRATION";
    Tabs[Tabs["MULTIFACTOR"] = 6] = "MULTIFACTOR";
    Tabs[Tabs["PROXY"] = 7] = "PROXY";
    Tabs[Tabs["USERNAME_ATTRIBUTE"] = 8] = "USERNAME_ATTRIBUTE";
    Tabs[Tabs["ATTRIBUTE_RELEASE"] = 9] = "ATTRIBUTE_RELEASE";
    Tabs[Tabs["PROPERTIES"] = 10] = "PROPERTIES";
    Tabs[Tabs["ADVANCED"] = 11] = "ADVANCED";
})(Tabs || (Tabs = {}));
var FormComponent = (function () {
    function FormComponent(messages, route, router, service, data, location, snackBar) {
        this.messages = messages;
        this.route = route;
        this.router = router;
        this.service = service;
        this.data = data;
        this.location = location;
        this.snackBar = snackBar;
    }
    FormComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.data
            .subscribe(function (data) {
            if (data.resp) {
                _this.loadService(data.resp);
                _this.goto(Tabs.BASICS);
            }
        });
    };
    FormComponent.prototype.goto = function (tab) {
        var route = [{ outlets: { form: [this.tabRoute(tab)] } }];
        this.router.navigate(route, { skipLocationChange: true, relativeTo: this.route });
    };
    FormComponent.prototype.save = function () {
        this.saveForm();
        this.data.save.emit();
        this.data.submitted = true;
    };
    FormComponent.prototype.loadService = function (form) {
        var _this = this;
        this.data.service = form;
        this.data.submitted = false;
        this.data.form = this;
        this.service.formData().then(function (resp) {
            _this.data.formData = resp;
        });
    };
    FormComponent.prototype.isOidc = function () {
        return __WEBPACK_IMPORTED_MODULE_10__domain_oauth_service__["b" /* OidcRegisteredService */].instanceOf(this.data.service);
    };
    FormComponent.prototype.isSaml = function () {
        return __WEBPACK_IMPORTED_MODULE_11__domain_saml_service__["a" /* SamlRegisteredService */].instanceOf(this.data.service);
    };
    FormComponent.prototype.isWsFed = function () {
        return __WEBPACK_IMPORTED_MODULE_12__domain_wsed_service__["a" /* WSFederationRegisterdService */].instanceOf(this.data.service);
    };
    FormComponent.prototype.isOauth = function () {
        return __WEBPACK_IMPORTED_MODULE_10__domain_oauth_service__["a" /* OAuthRegisteredService */].instanceOf(this.data.service);
    };
    FormComponent.prototype.isCas = function () {
        return __WEBPACK_IMPORTED_MODULE_6__domain_registered_service__["a" /* RegexRegisteredService */].instanceOf(this.data.service);
    };
    FormComponent.prototype.tabRoute = function (tab) {
        if (tab > 0 && this.isCas()) {
            tab++;
        }
        switch (tab) {
            case Tabs.BASICS:
                return 'basics';
            case Tabs.TYPE:
                if (this.isSaml()) {
                    return 'saml';
                }
                if (this.isOauth()) {
                    return 'oauth';
                }
                if (this.isOidc()) {
                    return 'oidc';
                }
                if (this.isWsFed()) {
                    return 'wsfed';
                }
                break;
            case Tabs.CONTACTS:
                return 'contacts';
            case Tabs.LOGOUT:
                return 'logout';
            case Tabs.ACCESS_STRATEGY:
                return 'accessstrategy';
            case Tabs.EXPIRATION:
                return 'expiration';
            case Tabs.MULTIFACTOR:
                return 'multiauth';
            case Tabs.PROXY:
                return 'proxy';
            case Tabs.USERNAME_ATTRIBUTE:
                return 'userattr';
            case Tabs.ATTRIBUTE_RELEASE:
                return 'attrRelease';
            case Tabs.PROPERTIES:
                return 'properties';
            case Tabs.ADVANCED:
                return 'advanced';
        }
    };
    FormComponent.prototype.textareaArrParse = function (dir, value) {
        var newValue;
        if (dir === 'load') {
            newValue = value ? value.join('\n') : '';
        }
        else {
            if (value !== undefined) {
                newValue = value.split('\n');
                for (var i = newValue.length - 1; i >= 0; i--) {
                    newValue[i] = newValue[i].trim();
                }
            }
            else {
                newValue = [];
            }
        }
        return newValue;
    };
    ;
    FormComponent.prototype.saveForm = function () {
        var _this = this;
        var formErrors = -1;
        this.clearErrors();
        formErrors = this.validateForm();
        if (formErrors > -1) {
            this.snackBar.open(this.messages.services_form_alert_formHasErrors, 'Dismiss', {
                duration: 5000
            });
            this.tabGroup.selectedIndex = (formErrors > 0 && this.isCas()) ? formErrors - 1 : formErrors;
        }
        else {
            this.service.saveService(this.data.service)
                .then(function (resp) { return _this.handleSave(resp); })
                .catch(function (e) { return _this.handleNotSaved(e); });
        }
    };
    ;
    FormComponent.prototype.clearErrors = function () {
        var missing = document.getElementsByClassName('required-missing');
        var i = 0;
        var j = missing.length;
        for (i = 0; i < j; i++) {
            missing.item(0).classList.remove('required-missing');
        }
    };
    FormComponent.prototype.handleSave = function (id) {
        var hasIdAssignedAlready = this.data.service.id && this.data.service.id > 0;
        if (!hasIdAssignedAlready && id && id !== -1) {
            this.data.service.id = id;
            this.snackBar.open(this.messages.services_form_alert_serviceAdded, 'Dismiss', {
                duration: 5000
            });
        }
        else {
            this.snackBar.open(this.messages.services_form_alert_serviceUpdated, 'Dismiss', {
                duration: 5000
            });
        }
        this.data.service.id = id;
        this.location.back();
    };
    FormComponent.prototype.handleNotSaved = function (e) {
        this.snackBar.open(this.messages.services_form_alert_unableToSave, 'Dismiss', {
            duration: 5000
        });
    };
    FormComponent.prototype.validateRegex = function (pattern) {
        try {
            if (pattern === '') {
                return false;
            }
            var patt = new RegExp(pattern);
            return true;
        }
        catch (e) {
            console.log('Failed regex');
            return false;
        }
    };
    FormComponent.prototype.validateForm = function () {
        var data = this.data.service;
        // Service Basics
        if (!data.serviceId ||
            !this.validateRegex(data.serviceId) ||
            !data.name) {
            return Tabs.BASICS;
        }
        if (this.isOauth()) {
            var oauth = data;
            if (!oauth.clientId ||
                !oauth.clientSecret) {
                return Tabs.TYPE;
            }
        }
        if (this.isOidc()) {
            var oidc = data;
            if (!oidc.clientId ||
                !oidc.clientSecret ||
                !oidc.jwks ||
                !oidc.idTokenEncryptionAlg ||
                !oidc.idTokenEncryptionEncoding) {
                return Tabs.TYPE;
            }
        }
        if (this.isSaml()) {
            var saml = data;
            if (!saml.metadataLocation) {
                return Tabs.TYPE;
            }
        }
        if (this.isWsFed()) {
            var wsfed = data;
            if (!wsfed.appliesTo) {
                return Tabs.TYPE;
            }
        }
        if (__WEBPACK_IMPORTED_MODULE_14__domain_access_strategy__["b" /* GrouperRegisteredServiceAccessStrategy */].instanceOf(data.accessStrategy)) {
            var grouper = data.accessStrategy;
            if (!grouper.groupField) {
                return Tabs.ACCESS_STRATEGY;
            }
        }
        // Username Attribute Provider Options
        if (__WEBPACK_IMPORTED_MODULE_8__domain_attribute_provider__["c" /* PrincipalAttributeRegisteredServiceUsernameProvider */].instanceOf(data.usernameAttributeProvider)) {
            var attrProvider = data.usernameAttributeProvider;
            if (!attrProvider.usernameAttribute) {
                return Tabs.USERNAME_ATTRIBUTE;
            }
            if (attrProvider.encryptUserName && (!data.publicKey || !data.publicKey.location)) {
                return Tabs.ADVANCED;
            }
        }
        if (__WEBPACK_IMPORTED_MODULE_8__domain_attribute_provider__["a" /* AnonymousRegisteredServiceUsernameProvider */].instanceOf(data.usernameAttributeProvider)) {
            var anonProvider = data.usernameAttributeProvider;
            if (!anonProvider.persistentIdGenerator) {
                return Tabs.USERNAME_ATTRIBUTE;
            }
        }
        // Proxy Policy Options
        if (__WEBPACK_IMPORTED_MODULE_9__domain_proxy_policy_ts__["b" /* RegexMatchingRegisteredServiceProxyPolicy */].instanceOf(data.proxyPolicy)) {
            var regPolicy = data.proxyPolicy;
            if (!regPolicy.pattern || !this.validateRegex(regPolicy.pattern)) {
                return Tabs.PROXY;
            }
        }
        // Principle Attribute Repository Options
        if (__WEBPACK_IMPORTED_MODULE_7__domain_attribute_repo__["a" /* CachingPrincipalAttributesRepository */].instanceOf(data.attributeReleasePolicy.principalAttributesRepository)) {
            var cache = data.attributeReleasePolicy.principalAttributesRepository;
            if (!cache.timeUnit) {
                return Tabs.ATTRIBUTE_RELEASE;
            }
            if (!cache.mergingStrategy) {
                return Tabs.ATTRIBUTE_RELEASE;
            }
        }
        if (data.attributeReleasePolicy.attributeFilter != null) {
            var filter = data.attributeReleasePolicy.attributeFilter;
            if (!this.validateRegex(filter.pattern)) {
                return Tabs.ATTRIBUTE_RELEASE;
            }
        }
        if (data.attributeReleasePolicy.authorizedToReleaseProxyGrantingTicket ||
            data.attributeReleasePolicy.authorizedToReleaseCredentialPassword) {
            if (!data.publicKey || !data.publicKey.location) {
                return Tabs.ADVANCED;
            }
        }
        if (data.contacts) {
            for (var _i = 0, _a = data.contacts; _i < _a.length; _i++) {
                var contact = _a[_i];
                if (!contact.name || !contact.email) {
                    return Tabs.CONTACTS;
                }
            }
        }
        return -1;
    };
    ;
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])('tabGroup'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_13__angular_material__["x" /* MatTabGroup */])
    ], FormComponent.prototype, "tabGroup", void 0);
    FormComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-form',
            template: __webpack_require__("../../../../../src/app/form/form.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/form.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_4__form_service__["a" /* FormService */],
            __WEBPACK_IMPORTED_MODULE_5__data__["a" /* Data */],
            __WEBPACK_IMPORTED_MODULE_3__angular_common__["f" /* Location */],
            __WEBPACK_IMPORTED_MODULE_13__angular_material__["v" /* MatSnackBar */]])
    ], FormComponent);
    return FormComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/form.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__form_routing_module__ = __webpack_require__("../../../../../src/app/form/form-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__form_component__ = __webpack_require__("../../../../../src/app/form/form.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__form_resolover__ = __webpack_require__("../../../../../src/app/form/form.resolover.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__tab_basics_tab_basics_component__ = __webpack_require__("../../../../../src/app/form/tab-basics/tab-basics.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__tab_logout_tab_logout_component__ = __webpack_require__("../../../../../src/app/form/tab-logout/tab-logout.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__tab_accessstrategy_tab_accessstrategy_component__ = __webpack_require__("../../../../../src/app/form/tab-accessstrategy/tab-accessstrategy.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__tab_mulitauth_tab_mulitauth_component__ = __webpack_require__("../../../../../src/app/form/tab-mulitauth/tab-mulitauth.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__tab_proxy_tab_proxy_component__ = __webpack_require__("../../../../../src/app/form/tab-proxy/tab-proxy.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__tab_usernameattr_tab_usernameattr_component__ = __webpack_require__("../../../../../src/app/form/tab-usernameattr/tab-usernameattr.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__tab_attrrelease_tab_attrrelease_component__ = __webpack_require__("../../../../../src/app/form/tab-attrrelease/tab-attrrelease.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__tab_properties_tab_properties_component__ = __webpack_require__("../../../../../src/app/form/tab-properties/tab-properties.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__form_service__ = __webpack_require__("../../../../../src/app/form/form.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__access_strategy_access_strategy_component__ = __webpack_require__("../../../../../src/app/form/access-strategy/access-strategy.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__attribute_release_attribute_release_component__ = __webpack_require__("../../../../../src/app/form/attribute-release/attribute-release.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__enabled_enabled_component__ = __webpack_require__("../../../../../src/app/form/enabled/enabled.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__evalorder_evalorder_component__ = __webpack_require__("../../../../../src/app/form/evalorder/evalorder.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__linkrefs_linkrefs_component__ = __webpack_require__("../../../../../src/app/form/linkrefs/linkrefs.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21__logo_logo_component__ = __webpack_require__("../../../../../src/app/form/logo/logo.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_22__logout_logout_component__ = __webpack_require__("../../../../../src/app/form/logout/logout.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23__logouttypeeval_logouttypeeval_component__ = __webpack_require__("../../../../../src/app/form/logouttypeeval/logouttypeeval.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_24__multiauthpane_multiauthpane_component__ = __webpack_require__("../../../../../src/app/form/multiauthpane/multiauthpane.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_25__oauthclient_oauthclient_component__ = __webpack_require__("../../../../../src/app/form/oauthclient/oauthclient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_26__propertiespane_propertiespane_component__ = __webpack_require__("../../../../../src/app/form/propertiespane/propertiespane.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_27__proxy_proxy_component__ = __webpack_require__("../../../../../src/app/form/proxy/proxy.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_28__pubkey_pubkey_component__ = __webpack_require__("../../../../../src/app/form/pubkey/pubkey.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_29__rejectedattributes_rejectedattributes_component__ = __webpack_require__("../../../../../src/app/form/rejectedattributes/rejectedattributes.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_30__reqhandlers_reqhandlers_component__ = __webpack_require__("../../../../../src/app/form/reqhandlers/reqhandlers.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_31__samlclient_samlclient_component__ = __webpack_require__("../../../../../src/app/form/samlclient/samlclient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_32__servicedesc_servicedesc_component__ = __webpack_require__("../../../../../src/app/form/servicedesc/servicedesc.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_33__serviceid_serviceid_component__ = __webpack_require__("../../../../../src/app/form/serviceid/serviceid.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_34__servicename_servicename_component__ = __webpack_require__("../../../../../src/app/form/servicename/servicename.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_35__servicetype_servicetype_component__ = __webpack_require__("../../../../../src/app/form/servicetype/servicetype.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_36__themeid_themeid_component__ = __webpack_require__("../../../../../src/app/form/themeid/themeid.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_37__uidattrs_uidattrs_component__ = __webpack_require__("../../../../../src/app/form/uidattrs/uidattrs.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_38__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_39__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_40__tab_advanced_tab_advanced_component__ = __webpack_require__("../../../../../src/app/form/tab-advanced/tab-advanced.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_41__attribute_release_checks_attribute_release_checks_component__ = __webpack_require__("../../../../../src/app/form/attribute-release-checks/attribute-release-checks.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_42__attribute_release_filters_attribute_release_filters_component__ = __webpack_require__("../../../../../src/app/form/attribute-release-filters/attribute-release-filters.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_43__attribute_release_policies_attribute_release_policies_component__ = __webpack_require__("../../../../../src/app/form/attribute-release-policies/attribute-release-policies.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_44__attribute_release_principal_repo_attribute_release_principal_repo_component__ = __webpack_require__("../../../../../src/app/form/attribute-release-principal-repo/attribute-release-principal-repo.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_45__wsfedclient_wsfedclient_component__ = __webpack_require__("../../../../../src/app/form/wsfedclient/wsfedclient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_46__wsfedattrrelpolocies_wsfedattrrelpolicies_component__ = __webpack_require__("../../../../../src/app/form/wsfedattrrelpolocies/wsfedattrrelpolicies.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_47__samlservicespane_samlservicespane_component__ = __webpack_require__("../../../../../src/app/form/samlservicespane/samlservicespane.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_48__access_strategy_remote_remote_component__ = __webpack_require__("../../../../../src/app/form/access-strategy/remote/remote.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_49__access_strategy_time_time_component__ = __webpack_require__("../../../../../src/app/form/access-strategy/time/time.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_50__access_strategy_grouper_grouper_component__ = __webpack_require__("../../../../../src/app/form/access-strategy/grouper/grouper.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_51__oidcclient_oidcclient_component__ = __webpack_require__("../../../../../src/app/form/oidcclient/oidcclient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_52__mappedattributes_mappedattributes_component__ = __webpack_require__("../../../../../src/app/form/mappedattributes/mappedattributes.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_53__tab_oauth_tab_oauth_component__ = __webpack_require__("../../../../../src/app/form/tab-oauth/tab-oauth.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_54__tab_saml_tab_saml_component__ = __webpack_require__("../../../../../src/app/form/tab-saml/tab-saml.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_55__tab_wsfed_tab_wsfed_component__ = __webpack_require__("../../../../../src/app/form/tab-wsfed/tab-wsfed.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_56__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_57__attribute_release_consent_attribute_release_consent_component__ = __webpack_require__("../../../../../src/app/form/attribute-release-consent/attribute-release-consent.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_58__access_strategy_surrogate_surrogate_component__ = __webpack_require__("../../../../../src/app/form/access-strategy/surrogate/surrogate.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_59__contacts_contacts_component__ = __webpack_require__("../../../../../src/app/form/contacts/contacts.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_60__tab_contacts_tab_contacts_component__ = __webpack_require__("../../../../../src/app/form/tab-contacts/tab-contacts.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_61__expiration_expiration_component__ = __webpack_require__("../../../../../src/app/form/expiration/expiration.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_62__tab_expiration_tab_expiration_component__ = __webpack_require__("../../../../../src/app/form/tab-expiration/tab-expiration.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_63__samlclient_metadata_metadata_component__ = __webpack_require__("../../../../../src/app/form/samlclient/metadata/metadata.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_64__samlclient_security_security_component__ = __webpack_require__("../../../../../src/app/form/samlclient/security/security.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_65__samlclient_optional_optional_component__ = __webpack_require__("../../../../../src/app/form/samlclient/optional/optional.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_66__samlclient_nameid_nameid_component__ = __webpack_require__("../../../../../src/app/form/samlclient/nameid/nameid.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_67__attribute_release_filters_mapped_mapped_component__ = __webpack_require__("../../../../../src/app/form/attribute-release-filters/mapped/mapped.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_68__tab_oidc_tab_oidc_component__ = __webpack_require__("../../../../../src/app/form/tab-oidc/tab-oidc.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by tschmidt on 2/23/17.
 */





































































var FormModule = (function () {
    function FormModule() {
    }
    FormModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_common__["b" /* CommonModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_http__["b" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_39__shared_shared_module__["a" /* SharedModule */],
                __WEBPACK_IMPORTED_MODULE_4__form_routing_module__["a" /* FormRoutingModule */]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_5__form_component__["a" /* FormComponent */],
                __WEBPACK_IMPORTED_MODULE_7__tab_basics_tab_basics_component__["a" /* TabBasicsComponent */],
                __WEBPACK_IMPORTED_MODULE_8__tab_logout_tab_logout_component__["a" /* TabLogoutComponent */],
                __WEBPACK_IMPORTED_MODULE_9__tab_accessstrategy_tab_accessstrategy_component__["a" /* TabAccessstrategyComponent */],
                __WEBPACK_IMPORTED_MODULE_10__tab_mulitauth_tab_mulitauth_component__["a" /* TabMulitauthComponent */],
                __WEBPACK_IMPORTED_MODULE_11__tab_proxy_tab_proxy_component__["a" /* TabProxyComponent */],
                __WEBPACK_IMPORTED_MODULE_12__tab_usernameattr_tab_usernameattr_component__["a" /* TabUsernameattrComponent */],
                __WEBPACK_IMPORTED_MODULE_13__tab_attrrelease_tab_attrrelease_component__["a" /* TabAttrreleaseComponent */],
                __WEBPACK_IMPORTED_MODULE_14__tab_properties_tab_properties_component__["a" /* TabPropertiesComponent */],
                __WEBPACK_IMPORTED_MODULE_40__tab_advanced_tab_advanced_component__["a" /* TabAdvancedComponent */],
                __WEBPACK_IMPORTED_MODULE_54__tab_saml_tab_saml_component__["a" /* TabSamlComponent */],
                __WEBPACK_IMPORTED_MODULE_53__tab_oauth_tab_oauth_component__["a" /* TabOauthComponent */],
                __WEBPACK_IMPORTED_MODULE_68__tab_oidc_tab_oidc_component__["a" /* TabOIDCComponent */],
                __WEBPACK_IMPORTED_MODULE_55__tab_wsfed_tab_wsfed_component__["a" /* TabWsfedComponent */],
                __WEBPACK_IMPORTED_MODULE_56__tab_base__["a" /* TabBaseComponent */],
                __WEBPACK_IMPORTED_MODULE_5__form_component__["a" /* FormComponent */],
                __WEBPACK_IMPORTED_MODULE_16__access_strategy_access_strategy_component__["a" /* AccessStrategyComponent */],
                __WEBPACK_IMPORTED_MODULE_17__attribute_release_attribute_release_component__["a" /* AttributeReleaseComponent */],
                __WEBPACK_IMPORTED_MODULE_18__enabled_enabled_component__["a" /* EnabledComponent */],
                __WEBPACK_IMPORTED_MODULE_19__evalorder_evalorder_component__["a" /* EvalorderComponent */],
                __WEBPACK_IMPORTED_MODULE_20__linkrefs_linkrefs_component__["a" /* LinkrefsComponent */],
                __WEBPACK_IMPORTED_MODULE_21__logo_logo_component__["a" /* LogoComponent */],
                __WEBPACK_IMPORTED_MODULE_22__logout_logout_component__["a" /* LogoutComponent */],
                __WEBPACK_IMPORTED_MODULE_23__logouttypeeval_logouttypeeval_component__["a" /* LogouttypeevalComponent */],
                __WEBPACK_IMPORTED_MODULE_24__multiauthpane_multiauthpane_component__["a" /* MultiauthpaneComponent */],
                __WEBPACK_IMPORTED_MODULE_25__oauthclient_oauthclient_component__["a" /* OauthclientComponent */],
                __WEBPACK_IMPORTED_MODULE_26__propertiespane_propertiespane_component__["a" /* PropertiespaneComponent */],
                __WEBPACK_IMPORTED_MODULE_27__proxy_proxy_component__["a" /* ProxyComponent */],
                __WEBPACK_IMPORTED_MODULE_28__pubkey_pubkey_component__["a" /* PubkeyComponent */],
                __WEBPACK_IMPORTED_MODULE_29__rejectedattributes_rejectedattributes_component__["a" /* RejectedattributesComponent */],
                __WEBPACK_IMPORTED_MODULE_30__reqhandlers_reqhandlers_component__["a" /* ReqhandlersComponent */],
                __WEBPACK_IMPORTED_MODULE_31__samlclient_samlclient_component__["a" /* SamlclientComponent */],
                __WEBPACK_IMPORTED_MODULE_32__servicedesc_servicedesc_component__["a" /* ServicedescComponent */],
                __WEBPACK_IMPORTED_MODULE_33__serviceid_serviceid_component__["a" /* ServiceidComponent */],
                __WEBPACK_IMPORTED_MODULE_34__servicename_servicename_component__["a" /* ServicenameComponent */],
                __WEBPACK_IMPORTED_MODULE_35__servicetype_servicetype_component__["a" /* ServicetypeComponent */],
                __WEBPACK_IMPORTED_MODULE_36__themeid_themeid_component__["a" /* ThemeidComponent */],
                __WEBPACK_IMPORTED_MODULE_37__uidattrs_uidattrs_component__["a" /* UidattrsComponent */],
                __WEBPACK_IMPORTED_MODULE_41__attribute_release_checks_attribute_release_checks_component__["a" /* AttributeReleaseChecksComponent */],
                __WEBPACK_IMPORTED_MODULE_42__attribute_release_filters_attribute_release_filters_component__["a" /* AttributeReleaseFiltersComponent */],
                __WEBPACK_IMPORTED_MODULE_43__attribute_release_policies_attribute_release_policies_component__["a" /* AttributeReleasePoliciesComponent */],
                __WEBPACK_IMPORTED_MODULE_44__attribute_release_principal_repo_attribute_release_principal_repo_component__["a" /* AttributeReleasePrincipalRepoComponent */],
                __WEBPACK_IMPORTED_MODULE_45__wsfedclient_wsfedclient_component__["a" /* WsfedclientComponent */],
                __WEBPACK_IMPORTED_MODULE_46__wsfedattrrelpolocies_wsfedattrrelpolicies_component__["a" /* WsfedattrrelpoliciesComponent */],
                __WEBPACK_IMPORTED_MODULE_47__samlservicespane_samlservicespane_component__["a" /* SamlservicespaneComponent */],
                __WEBPACK_IMPORTED_MODULE_48__access_strategy_remote_remote_component__["a" /* RemoteComponent */],
                __WEBPACK_IMPORTED_MODULE_49__access_strategy_time_time_component__["a" /* TimeComponent */],
                __WEBPACK_IMPORTED_MODULE_50__access_strategy_grouper_grouper_component__["a" /* GrouperComponent */],
                __WEBPACK_IMPORTED_MODULE_51__oidcclient_oidcclient_component__["a" /* OidcclientComponent */],
                __WEBPACK_IMPORTED_MODULE_52__mappedattributes_mappedattributes_component__["a" /* MappedattributesComponent */],
                __WEBPACK_IMPORTED_MODULE_53__tab_oauth_tab_oauth_component__["a" /* TabOauthComponent */],
                __WEBPACK_IMPORTED_MODULE_54__tab_saml_tab_saml_component__["a" /* TabSamlComponent */],
                __WEBPACK_IMPORTED_MODULE_55__tab_wsfed_tab_wsfed_component__["a" /* TabWsfedComponent */],
                __WEBPACK_IMPORTED_MODULE_57__attribute_release_consent_attribute_release_consent_component__["a" /* AttributeReleaseConsentComponent */],
                __WEBPACK_IMPORTED_MODULE_58__access_strategy_surrogate_surrogate_component__["a" /* SurrogateComponent */],
                __WEBPACK_IMPORTED_MODULE_59__contacts_contacts_component__["a" /* ContactsComponent */],
                __WEBPACK_IMPORTED_MODULE_60__tab_contacts_tab_contacts_component__["a" /* TabContactsComponent */],
                __WEBPACK_IMPORTED_MODULE_61__expiration_expiration_component__["a" /* ExpirationComponent */],
                __WEBPACK_IMPORTED_MODULE_62__tab_expiration_tab_expiration_component__["a" /* TabExpirationComponent */],
                __WEBPACK_IMPORTED_MODULE_63__samlclient_metadata_metadata_component__["a" /* MetadataComponent */],
                __WEBPACK_IMPORTED_MODULE_64__samlclient_security_security_component__["a" /* SecurityComponent */],
                __WEBPACK_IMPORTED_MODULE_65__samlclient_optional_optional_component__["a" /* OptionalComponent */],
                __WEBPACK_IMPORTED_MODULE_66__samlclient_nameid_nameid_component__["a" /* NameidComponent */],
                __WEBPACK_IMPORTED_MODULE_67__attribute_release_filters_mapped_mapped_component__["a" /* MappedComponent */],
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_6__form_resolover__["a" /* FormResolve */],
                __WEBPACK_IMPORTED_MODULE_15__form_service__["a" /* FormService */],
                __WEBPACK_IMPORTED_MODULE_38__data__["a" /* Data */]
            ]
        })
    ], FormModule);
    return FormModule;
}());



/***/ }),

/***/ "../../../../../src/app/form/form.resolover.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormResolve; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__form_service__ = __webpack_require__("../../../../../src/app/form/form.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__domain_registered_service__ = __webpack_require__("../../../../../src/domain/registered-service.ts");
/**
 * Created by tschmidt on 2/13/17.
 */
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var FormResolve = (function () {
    function FormResolve(service, router) {
        this.service = service;
        this.router = router;
    }
    FormResolve.prototype.resolve = function (route) {
        var param = route.params['id'];
        if (!param || param === '-1') {
            return new Promise(function (resolve, reject) { return resolve(new __WEBPACK_IMPORTED_MODULE_3__domain_registered_service__["a" /* RegexRegisteredService */]()); });
        }
        else {
            return this.service.getService(param).then(function (resp) {
                if (resp) {
                    if (route.data.duplicate) {
                        resp.id = -1;
                    }
                    return resp;
                }
                else {
                    return null;
                }
            });
        }
    };
    FormResolve = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__form_service__["a" /* FormService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], FormResolve);
    return FormResolve;
}());



/***/ }),

/***/ "../../../../../src/app/form/form.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var FormService = (function () {
    function FormService(http) {
        this.http = http;
    }
    FormService.prototype.getService = function (id) {
        return this.http.get('getService?id=' + id)
            .toPromise()
            .then(function (resp) {
            var as = resp;
            return as;
        })
            .catch(this.handleError);
    };
    FormService.prototype.saveService = function (service) {
        return this.http
            .post('saveService', service)
            .toPromise()
            .then(function (resp) { return resp; })
            .catch(this.handleError);
    };
    FormService.prototype.formData = function () {
        return this.http.get('formData')
            .toPromise()
            .then(function (resp) { return resp; })
            .catch(this.handleError);
    };
    FormService.prototype.handleError = function (e) {
        console.log('An error occurred : ' + e);
        return Promise.reject(e.message || e);
    };
    FormService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], FormService);
    return FormService;
}());



/***/ }),

/***/ "../../../../../src/app/form/linkrefs/linkrefs.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.informationUrl\"\n           [placeholder]=\"messages.services_form_label_informationUrl\"\n           [(ngModel)]=\"data.service.informationUrl\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.informationUrl\"\n           [matTooltip]=\"messages.services_form_tooltip_informationUrl\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.privacyUrl\"\n           [placeholder]=\"messages.services_form_label_privacyUrl\"\n           [(ngModel)]=\"data.service.privacyUrl\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.privacyUrl\"\n           [matTooltip]=\"messages.services_form_tooltip_privacyUrl\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/linkrefs/linkrefs.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LinkrefsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LinkrefsComponent = (function () {
    function LinkrefsComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    LinkrefsComponent.prototype.ngOnInit = function () {
    };
    LinkrefsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-linkrefs',
            template: __webpack_require__("../../../../../src/app/form/linkrefs/linkrefs.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], LinkrefsComponent);
    return LinkrefsComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/logo/logo.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.logoUrl\"\n           [placeholder]=\"messages.services_form_label_logoUrl\"\n           [(ngModel)]=\"data.service.logo\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.logoUrl\"\n          [matTooltip]=\"messages.services_form_tooltip_logoUrl\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/logo/logo.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LogoComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LogoComponent = (function () {
    function LogoComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    LogoComponent.prototype.ngOnInit = function () {
    };
    LogoComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-logo',
            template: __webpack_require__("../../../../../src/app/form/logo/logo.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], LogoComponent);
    return LogoComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/logout/logout.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.logoutUrl\"\n           [placeholder]=\"messages.services_form_label_logoutUrl\"\n           [(ngModel)]=\"data.service.logoutUrl\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.logoutUrl\"\n           [matTooltip]=\"messages.services_form_tooltip_logoutUrl\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/logout/logout.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LogoutComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LogoutComponent = (function () {
    function LogoutComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    LogoutComponent.prototype.ngOnInit = function () {
    };
    LogoutComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-logout',
            template: __webpack_require__("../../../../../src/app/form/logout/logout.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], LogoutComponent);
    return LogoutComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/logouttypeeval/logouttypeeval.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.logoutType\"\n               [placeholder]=\"messages.services_form_label_logoutType\"\n               [(ngModel)]=\"data.service.logoutType\">\n      <mat-option *ngFor=\"let opt of data.formData.logoutTypes\" [value]=\"opt\">{{ opt }}</mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.logoutType\"\n           [matTooltip]=\"messages.services_form_tooltip_logoutType\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/logouttypeeval/logouttypeeval.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LogouttypeevalComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LogouttypeevalComponent = (function () {
    function LogouttypeevalComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    LogouttypeevalComponent.prototype.ngOnInit = function () {
    };
    LogouttypeevalComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-logouttypeeval',
            template: __webpack_require__("../../../../../src/app/form/logouttypeeval/logouttypeeval.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], LogouttypeevalComponent);
    return LogouttypeevalComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/mappedattributes/mappedattributes.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/mappedattributes/mappedattributes.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-table [dataSource]=\"dataSource\">\n\n    <ng-container cdkColumnDef=\"source\">\n      <mat-header-cell *cdkHeaderCellDef>\n        <ng-container i18n=\"services.form.label.attrRelease.policies.sourceAttribute\">\n          {{ messages.services_form_label_attrRelease_policies_sourceAttribute }}\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\"> {{ row.source }}</mat-cell>\n    </ng-container>\n\n    <ng-container cdkColumnDef=\"mapped\">\n      <mat-header-cell *cdkHeaderCellDef>\n        <ng-container i18n=\"services.form.label.attrRelease.policies.casAttribute\">\n          {{ messages.services_form_label_attrRelease_policies_casAttribute }}\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\">\n        <mat-form-field>\n          <input matInput\n                 [ngModel]=\"attributes[row.source]\"\n                 (ngModelChange)=\"attributes[row.source] = $event.split(',')\">\n        </mat-form-field>\n      </mat-cell>\n    </ng-container>\n\n    <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n    <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n  </mat-table>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/mappedattributes/mappedattributes.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MappedattributesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/_esm5/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var MappedattributesComponent = (function () {
    function MappedattributesComponent(messages, data, changeDetector) {
        this.messages = messages;
        this.data = data;
        this.changeDetector = changeDetector;
        this.displayedColumns = ['source', 'mapped'];
        this.formData = data.formData;
    }
    MappedattributesComponent.prototype.ngOnInit = function () {
        var rows = [];
        for (var _i = 0, _a = Array.from(Object.keys(this.attributes)); _i < _a.length; _i++) {
            var key = _a[_i];
            rows.push(new __WEBPACK_IMPORTED_MODULE_6__row__["a" /* Row */](key));
        }
        ;
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_6__row__["b" /* RowDataSource */](rows);
        this.changeDetector.detectChanges();
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Map)
    ], MappedattributesComponent.prototype, "attributes", void 0);
    MappedattributesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-mappedattributes',
            template: __webpack_require__("../../../../../src/app/form/mappedattributes/mappedattributes.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/mappedattributes/mappedattributes.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_5__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_4__data__["a" /* Data */],
            __WEBPACK_IMPORTED_MODULE_0__angular_core__["k" /* ChangeDetectorRef */]])
    ], MappedattributesComponent);
    return MappedattributesComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/multiauthpane/multiauthpane.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select multiple\n           i18n-placeholder=\"services.form.label.multiauth.providers\"\n           [placeholder]=\"messages.services_form_label_multiauth_providers\"\n           [(ngModel)]=\"data.service.multifactorPolicy.multifactorAuthenticationProviders\">\n      <mat-option *ngFor=\"let opt of formData.mfaProviders\" [value]=\"opt.value\">\n        {{ opt.display }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.multiauth_providers\"\n           [matTooltip]=\"messages.services_form_tooltip_multiauth_providers\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.multiauth.failuremode\"\n                [placeholder]=\"messages.services_form_label_multiauth_failuremode\"\n                [(ngModel)]=\"data.service.multifactorPolicy.failureMode\">\n      <mat-option *ngFor=\"let opt of formData.mfaFailureModes\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.multiauth.failuremode\"\n           [matTooltip]=\"messages.services_form_tooltip_multiauth_failuremode\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput [matAutocomplete]=\"auto\"\n           i18n-placeholder=\"services.form.label.multiauth.principalattribute.nametrigger\"\n           [placeholder]=\"messages.services_form_label_multiauth_principalattribute_nametrigger\"\n           [(ngModel)]=\"data.service.multifactorPolicy.principalAttributeNameTrigger\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.multiauth.principalattribute.nametrigger\"\n           [matTooltip]=\"messages.services_form_tooltip_multiauth_principalattribute_nametrigger\">help\n  </mat-icon>\n  <mat-autocomplete style=\"width:300px\" #auto=\"matAutocomplete\">\n    <mat-option *ngFor=\"let opt of formData.availableAttributes\" [value]=\"opt\">{{ opt }}</mat-option>\n  </mat-autocomplete>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.multiauth.principalattribute.valuetomatch\"\n           [placeholder]=\"messages.services_form_label_multiauth_principalattribute_valuetomatch\"\n           [(ngModel)]=\"data.service.multifactorPolicy.principalAttributeValueToMatch\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-myTooltip=\"services.form.tooltip.multiauth.principalattribute.valuetomatch\"\n           [matTooltip]=\"messages.services_form_tooltip_multiauth_principalattribute_valuetomatch\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"data.service.multifactorPolicy.bypassEnabled\">\n    <ng-container i18n=\"services.form.label.multiauth.bypassenabled\">\n      {{ messages.services_form_label_multiauth_bypassenabled }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.multiauth.bypassenabled\"\n             [matTooltip]=\"messages.services_form_tooltip_multiauth_bypassenabled\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/multiauthpane/multiauthpane.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MultiauthpaneComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var MultiauthpaneComponent = (function () {
    function MultiauthpaneComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.formData = data.formData;
    }
    MultiauthpaneComponent.prototype.ngOnInit = function () {
    };
    MultiauthpaneComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-multiauthpane',
            template: __webpack_require__("../../../../../src/app/form/multiauthpane/multiauthpane.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], MultiauthpaneComponent);
    return MultiauthpaneComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/oauthclient/oauthclient.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>OAuth Client Options</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput required\n           i18n-placeholder=\"services.form.label.oauthClientId\"\n           [placeholder]=\"messages.services_form_label_oauthClientId\"\n           [(ngModel)]=\"service.clientId\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.oauthClientId\"\n           [matTooltip]=\"messages.services_form_tooltip_oauthClientId\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput required [type]=\"showOAuthSecret ? 'text' : 'password'\"\n           i18n-placeholder=\"services.form.label.oauthClientSecret\"\n           [placeholder]=\"messages.services_form_label_oauthClientSecret\"\n           [(ngModel)]=\"service.clientSecret\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.oauthClientSecret\"\n           [matTooltip]=\"messages.services_form_tooltip_oauthClientSecret\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"showOAuthSecret\">\n    <ng-container i18n=\"services.form.label.oauthShowSecret\">\n      {{ messages.services_form_label_oauthShowSecret }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.oauthShowSecret\"\n             [matTooltip]=\"messages.services_form_tooltip_oauthShowSecret\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.bypassApprovalPrompt\">\n    <ng-container i18n=\"services.form.label.oauthBypass\">\n      {{ messages.services_form_label_oauthBypass }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.oauthBypass\"\n             [matTooltip]=\"messages.services_form_tooltip_oauthBypass\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.generateRefreshToken\">\n    <ng-container i18n=\"services.form.label.oauthRefreshToken\">\n      {{ messages.services_form_label_oauthRefreshToken }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.oauthRefreshToken\"\n             [matTooltip]=\"messages.services_form_tooltip_oauthRefreshToken\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox  [(ngModel)]=\"service.jsonFormat\">\n    <ng-container i18n=\"services.form.label.oauthJsonFormat\">\n      {{ messages.services_form_label_oauthJsonFormat }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n             i18n-matTooltip=\"services.form.tooltip.oauthJsonFormat\"\n             [matTooltip]=\"messages.services_form_tooltip_oauthJsonFormat\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n  </div>\n</mat-card>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/oauthclient/oauthclient.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OauthclientComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_oauth_service__ = __webpack_require__("../../../../../src/domain/oauth-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var OauthclientComponent = (function () {
    function OauthclientComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    OauthclientComponent.prototype.ngOnInit = function () {
    };
    OauthclientComponent.prototype.isOidc = function () {
        return __WEBPACK_IMPORTED_MODULE_2__domain_oauth_service__["b" /* OidcRegisteredService */].instanceOf(this.data.service);
    };
    OauthclientComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-oauthclient',
            template: __webpack_require__("../../../../../src/app/form/oauthclient/oauthclient.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], OauthclientComponent);
    return OauthclientComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/oidcclient/oidcclient.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/oidcclient/oidcclient.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>OIDC Client Options</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput required\n               i18n-placeholder=\"services.form.label.oidcClientId\"\n               [placeholder]=\"messages.services_form_label_oidcClientId\"\n               [(ngModel)]=\"service.clientId\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n                i18n-matTooltip=\"services.form.tooltip.oidcClientId\"\n                [matTooltip]=\"messages.services_form_tooltip_oidcClientId\">help\n      </mat-icon>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput required [type]=\"showOAuthSecret ? 'text' : 'password'\"\n               i18n-placeholder=\"services.form.label.oidcClientSecret\"\n               [placeholder]=\"messages.services_form_label_oidcClientSecret\"\n               [(ngModel)]=\"service.clientSecret\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n                i18n-matTooltip=\"services.form.tooltip.oidcClientSecret\"\n                [matTooltip]=\"messages.services_form_tooltip_oidcClientSecret\">help\n      </mat-icon>\n    </div>\n\n    <div>\n      <mat-checkbox [(ngModel)]=\"showOAuthSecret\">\n        <ng-container i18n=\"services.form.label.oidcShowSecret\">\n          {{ messages.services_form_label_oidcShowSecret }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                  i18n-matTooltip=\"services.form.tooltip.oidcShowSecret\"\n                  [matTooltip]=\"messages.services_form_tooltip_oidcShowSecret\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div>\n      <mat-checkbox [(ngModel)]=\"service.bypassApprovalPrompt\">\n        <ng-container i18n=\"services.form.label.oidcBypass\">\n          {{ messages.services_form_label_oidcBypass }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                  i18n-matTooltip=\"services.form.tooltip.oidcBypass\"\n                  [matTooltip]=\"messages.services_form_tooltip_oidcBypass\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div>\n      <mat-checkbox [(ngModel)]=\"service.generateRefreshToken\">\n        <ng-container i18n=\"services.form.label.oidcRefreshToken\">\n          {{ messages.services_form_label_oidcRefreshToken }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                  i18n-matTooltip=\"services.form.tooltip.oidcRefreshToken\"\n                  [matTooltip]=\"messages.services_form_tooltip_oidcRefreshToken\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div style=\"padding-bottom:10px;\">\n      <mat-checkbox  [(ngModel)]=\"service.jsonFormat\">\n        <ng-container i18n=\"services.form.label.oidcJsonFormat\">\n          {{ messages.services_form_label_oidcJsonFormat }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                  i18n-matTooltip=\"services.form.tooltip.oidcJsonFormat\"\n                  [matTooltip]=\"messages.services_form_tooltip_oidcJsonFormat\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput required\n               i18n-placeholder=\"services.form.label.oidc.jwks\"\n               [placeholder]=\"messages.services_form_label_oidc_jwks\"\n               [(ngModel)]=\"service.jwks\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.jwks\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_jwks\">help\n      </mat-icon>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\" *ngIf=\"service.scopes.indexOf('user_defined') > -1\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.oidc.user.defined.scopes\"\n               [placeholder]=\"messages.services_form_label_oidc_user_defined_scopes\"\n               [(ngModel)]=\"service.scopes_userdefined\"/>\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.user.defined.scopes\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_user_defined_scopes\">help\n      </mat-icon>\n    </div>\n\n    <div>\n      <mat-checkbox [(ngModel)]=\"service.signIdToken\">\n        <ng-container i18n=\"services.form.label.oidc.signToken\">\n          {{ messages.services_form_label_oidc_signToken }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"services.form.tooltip.oidc.signToken\"\n                 [matTooltip]=\"messages.services_form_tooltip_oidc_signToken\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div>\n      <mat-checkbox [(ngModel)]=\"service.implicit\">\n        <ng-container i18n=\"services.form.label.oidc.implicit\">\n          {{ messages.services_form_label_oidc_implicit }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"services.form.tooltip.oidc.implicit\"\n                 [matTooltip]=\"messages.services_form_tooltip_oidc_implicit\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div style=\"padding-bottom: 10px;\">\n      <mat-checkbox [(ngModel)]=\"service.encryptIdToken\">\n        <ng-container i18n=\"services.form.label.oidc.encrypt\">\n          {{ messages.services_form_label_oidc_encrypt }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium\"\n                 i18n-matTooltip=\"services.form.tooltip.oidc.encrypt\"\n                 [matTooltip]=\"messages.services_form_tooltip_oidc_encrypt\">help\n        </mat-icon>\n      </mat-checkbox>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput required [matAutocomplete]=\"encryptAlgAuto\"\n               i18n-placeholder=\"services.form.label.oidc.encryptAlg\"\n               [placeholder]=\"messages.services_form_label_oidc_encryptAlg\"\n               [(ngModel)]=\"service.idTokenEncryptionAlg\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.encryptAlg\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_encryptAlg\">help\n      </mat-icon>\n      <mat-autocomplete #encryptAlgAuto=\"matAutocomplete\">\n        <mat-option *ngFor=\"let opt of data.formData.oidcEncryptAlgOptions\" [value]=\"opt\">{{ opt }}</mat-option>\n      </mat-autocomplete>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput required [matAutocomplete]=\"encodingAlgAuto\"\n               i18n-placeholder=\"ervices.form.label.oidc.encryptEnc\"\n               [placeholder]=\"messages.services_form_label_oidc_encryptEnc\"\n               [(ngModel)]=\"service.idTokenEncryptionEncoding\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.encryptEnc\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_encryptEnc\">help\n      </mat-icon>\n      <mat-autocomplete #encodingAlgAuto=\"matAutocomplete\">\n        <mat-option *ngFor=\"let opt of data.formData.oidcEncodingAlgOptions\" [value]=\"opt\">{{ opt }}</mat-option>\n      </mat-autocomplete>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <mat-select i18n-placeholder=\"services.form.label.oidc.subject.type\"\n                    [placeholder]=\"messages.services_form_label_oidc_subject_type\"\n                    [(ngModel)]=\"service.subjectType\">\n          <mat-option *ngFor=\"let opt of data.formData.oidcSubjectTypes\" [value]=\"opt\">{{ opt }}</mat-option>\n        </mat-select>\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.subject.type\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_subject_type\">help\n      </mat-icon>\n    </div>\n\n    <div *ngIf=\"service.subjectType === 'PAIRWISE'\">\n      <mat-form-field class=\"textInput\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.oidc.sector.identifier.uri\"\n               [placeholder]=\"messages.services_form_label_oidc_sector_identifier_uri\"\n               [(ngModel)]=\"service.sectorIdentifierUri\"/>\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.sector.identifier.uri\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_sector_identifier_uri\">help\n      </mat-icon>\n    </div>\n\n    <div *ngIf=\"service.dynamicallyRegistered\">\n      <mat-form-field class=\"textInput\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.oidc.dynamicDate\"\n               [placeholder]=\"messages.services_form_label_oidc_dynamicDate\"\n               [(ngModel)]=\"service.dynamicRegistrationDateTime\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.oidc.dynamicDate\"\n               [matTooltip]=\"messages.services_form_tooltip_oidc_dynamicDate\">help\n      </mat-icon>\n    </div>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/oidcclient/oidcclient.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OidcclientComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var OidcclientComponent = (function () {
    function OidcclientComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    OidcclientComponent.prototype.ngOnInit = function () {
        if (!this.service.scopes) {
            this.service.scopes = [];
        }
    };
    OidcclientComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-oidcclient',
            template: __webpack_require__("../../../../../src/app/form/oidcclient/oidcclient.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/oidcclient/oidcclient.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], OidcclientComponent);
    return OidcclientComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/propertiespane/propertiespane.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".nameWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.valueWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.actionWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 40px;\n          flex: 0 0 40px;\n}\n\n/deep/.mat-autocomplete-panel {\n  min-width: 300px !important;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/propertiespane/propertiespane.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Properties</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <mat-table [dataSource]=\"dataSource\">\n\n      <ng-container cdkColumnDef=\"source\">\n        <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'nameWidth'\">Name</mat-header-cell>\n        <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n          <mat-form-field>\n            <input matInput #text [matAutocomplete]=\"auto\"\n                   [ngModel]=\"row.key\" (click)=\"selectedRow = row\"\n                   (change)=\"doChange(row,$event.target.value)\">\n          </mat-form-field>\n\n        </mat-cell>\n      </ng-container>\n\n      <ng-container cdkColumnDef=\"mapped\">\n        <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'valueWidth'\">Value</mat-header-cell>\n        <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'valueWidth'\">\n          <mat-form-field>\n            <input matInput [disabled]=\"row.key == ''\"\n                   [ngModel]=\"data.service.properties[row.key] ?  data.service.properties[row.key].values : ''\"\n                   (ngModelChange)=\"data.service.properties[row.key].values = $event.split(',')\">\n          </mat-form-field>\n        </mat-cell>\n      </ng-container>\n\n      <ng-container cdkColumnDef=\"delete\">\n        <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'actionWidth'\"></mat-header-cell>\n        <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n          <button mat-icon-button (click)=\"delete(row)\"><mat-icon style=\"font-size: medium\">delete</mat-icon></button>\n        </mat-cell>\n      </ng-container>\n\n      <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n      <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n\n    </mat-table>\n    <div style=\"height:25px;padding-top: 5px;\">\n      <button mat-mini-fab (click)=\"addRow()\" style=\"float:right;\">+</button>\n    </div>\n  </div>\n\n\n</mat-card>\n<mat-autocomplete #auto=\"matAutocomplete\" (optionSelected)=\"selection($event)\">\n  <mat-option *ngFor=\"let opt of formData.registeredServiceProperties\" [value]=\"opt\">{{ opt.propertyName }}</mat-option>\n</mat-autocomplete>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/propertiespane/propertiespane.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PropertiespaneComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__util_util__ = __webpack_require__("../../../../../src/app/util/util.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domain_property__ = __webpack_require__("../../../../../src/domain/property.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var PropertiespaneComponent = (function () {
    function PropertiespaneComponent(messages, data, changeRef) {
        this.messages = messages;
        this.data = data;
        this.changeRef = changeRef;
        this.displayedColumns = ['source', 'mapped', 'delete'];
        this.formData = data.formData;
    }
    PropertiespaneComponent.prototype.ngOnInit = function () {
        var rows = [];
        if (__WEBPACK_IMPORTED_MODULE_3__util_util__["a" /* Util */].isEmpty(this.data.service.properties)) {
            this.data.service.properties = new Map();
        }
        for (var _i = 0, _a = Array.from(Object.keys(this.data.service.properties)); _i < _a.length; _i++) {
            var p = _a[_i];
            rows.push(new __WEBPACK_IMPORTED_MODULE_5__row__["a" /* Row */](p));
        }
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_5__row__["b" /* RowDataSource */](rows);
    };
    PropertiespaneComponent.prototype.addRow = function () {
        this.dataSource.addRow();
    };
    PropertiespaneComponent.prototype.doChange = function (row, val) {
        if (Object.keys(this.data.service.properties).indexOf(row.key) > -1) {
            this.data.service.properties[val] = this.data.service.properties[row.key];
            delete this.data.service.properties[row.key];
        }
        else {
            this.data.service.properties[val] = new __WEBPACK_IMPORTED_MODULE_4__domain_property__["a" /* DefaultRegisteredServiceProperty */]();
        }
        row.key = val;
    };
    PropertiespaneComponent.prototype.delete = function (row) {
        delete this.data.service.properties[row.key];
        this.dataSource.removeRow(row);
    };
    PropertiespaneComponent.prototype.selection = function (val) {
        var opt = val.option.value;
        this.doChange(this.selectedRow, opt.propertyName);
        if (val) {
            this.data.service.properties[opt.propertyName].values = [opt.defaultValue];
        }
    };
    PropertiespaneComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-propertiespane',
            template: __webpack_require__("../../../../../src/app/form/propertiespane/propertiespane.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/propertiespane/propertiespane.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */],
            __WEBPACK_IMPORTED_MODULE_0__angular_core__["k" /* ChangeDetectorRef */]])
    ], PropertiespaneComponent);
    return PropertiespaneComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/proxy/proxy.component.html":
/***/ (function(module, exports) {

module.exports = "\n<mat-radio-group [(ngModel)]=\"type\" (change)=\"changeType()\">\n\n  <mat-radio-button [value]=\"TYPE.REFUSE\">\n    <ng-container i18n=\"services.form.label.proxyPolicy.refuse\">\n      {{ messages.services_form_label_proxyPolicy_refuse }}\n    </ng-container>\n  </mat-radio-button>\n\n  <mat-radio-button  [value]=\"TYPE.REGEX\">\n    <ng-container i18n=\"services.form.label.proxyPolicy.regex\">\n      {{ messages.services_form_label_proxyPolicy_regex }}\n    </ng-container>\n  </mat-radio-button>\n\n</mat-radio-group>\n\n<div *ngIf=\"type == TYPE.REGEX\">\n  <mat-form-field class=\"textInput\">\n    <input matInput required\n           i18n-placeholder=\"services.form.label.proxyPolicy.regex\"\n           [placeholder]=\"messages.services_form_label_proxyPolicy_regex\"\n           [(ngModel)]=\"data.service.proxyPolicy.pattern\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.proxyPolicy.regex\"\n           [matTooltip]=\"messages.services_form_tooltip_proxyPolicy_regex\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/proxy/proxy.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProxyComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_proxy_policy_ts__ = __webpack_require__("../../../../../src/domain/proxy-policy,ts.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var Type;
(function (Type) {
    Type[Type["REGEX"] = 0] = "REGEX";
    Type[Type["REFUSE"] = 1] = "REFUSE";
})(Type || (Type = {}));
var ProxyComponent = (function () {
    function ProxyComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.TYPE = Type;
    }
    ProxyComponent.prototype.ngOnInit = function () {
        if (__WEBPACK_IMPORTED_MODULE_2__domain_proxy_policy_ts__["a" /* RefuseRegisteredServiceProxyPolicy */].instanceOf(this.data.service.proxyPolicy)) {
            this.type = Type.REFUSE;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_proxy_policy_ts__["b" /* RegexMatchingRegisteredServiceProxyPolicy */].instanceOf(this.data.service.proxyPolicy)) {
            this.type = Type.REGEX;
        }
    };
    ProxyComponent.prototype.changeType = function () {
        switch (+this.type) {
            case Type.REFUSE:
                this.data.service.proxyPolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_proxy_policy_ts__["a" /* RefuseRegisteredServiceProxyPolicy */]();
                break;
            case Type.REGEX:
                this.data.service.proxyPolicy = new __WEBPACK_IMPORTED_MODULE_2__domain_proxy_policy_ts__["b" /* RegexMatchingRegisteredServiceProxyPolicy */]();
                break;
        }
    };
    ProxyComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-proxy',
            template: __webpack_require__("../../../../../src/app/form/proxy/proxy.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], ProxyComponent);
    return ProxyComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/pubkey/pubkey.component.html":
/***/ (function(module, exports) {

module.exports = "\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput [required]=\"data.service.usernameAttributeProvider.encryptUserName ||\n                               data.service.attributeReleasePolicy.authorizedToReleaseCredentialPassword ||\n                               data.service.attributeReleasePolicy.authorizedToReleaseProxyGrantingTicket\"\n           i18n-placeholder=\"services.form.label.pubKey.location\"\n           [placeholder]=\"messages.services_form_label_pubKey_location\"\n           [(ngModel)]=\"data.service.publicKey.location\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.pubKey.location\"\n           [matTooltip]=\"messages.services_form_tooltip_pubKey_location\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.pubKey.algorithm\"\n                [placeholder]=\"messages.services_form_label_pubKey_algorithm\"\n                [(ngModel)]=\"data.service.publicKey.algorithm\">\n      <mat-option value=\"RSA\">RSA</mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.pubKey.algorithm\"\n           [matTooltip]=\"messages.services_form_tooltip_pubKey_algorithm\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/pubkey/pubkey.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PubkeyComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_public_key__ = __webpack_require__("../../../../../src/domain/public-key.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var PubkeyComponent = (function () {
    function PubkeyComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    PubkeyComponent.prototype.ngOnInit = function () {
        if (!this.data.service.publicKey) {
            this.data.service.publicKey = new __WEBPACK_IMPORTED_MODULE_2__domain_public_key__["a" /* RegisteredServicePublicKeyImpl */]();
        }
    };
    PubkeyComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-pubkey',
            template: __webpack_require__("../../../../../src/app/form/pubkey/pubkey.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], PubkeyComponent);
    return PubkeyComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/rejectedattributes/rejectedattributes.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".nameWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.valueWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.actionWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 40px;\n          flex: 0 0 40px;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/rejectedattributes/rejectedattributes.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-table [dataSource]=\"dataSource\">\n\n    <ng-container cdkColumnDef=\"source\">\n      <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'nameWidth'\">Name</mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n        <mat-form-field>\n          <input matInput #text\n                 [ngModel]=\"row.key\"\n                 (change)=\"doChange(row,$event.target.value)\">\n        </mat-form-field>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container cdkColumnDef=\"mapped\">\n      <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'valueWidth'\">Value</mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'valueWidth'\">\n        <mat-form-field>\n          <input matInput\n                 [ngModel]=\"attributes[row.key]\"\n                 (ngModelChange)=\"attributes[row.key] = $event.split(',')\">\n        </mat-form-field>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container cdkColumnDef=\"delete\">\n      <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'actionWidth'\"></mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n        <button mat-icon-button (click)=\"delete(row)\"><mat-icon style=\"font-size: medium\">delete</mat-icon></button>\n      </mat-cell>\n    </ng-container>\n\n    <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n    <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n  </mat-table>\n  <div style=\"height:25px;padding-top: 5px;\">\n    <button mat-mini-fab (click)=\"addRow()\" style=\"float:right;\">+</button>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/rejectedattributes/rejectedattributes.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RejectedattributesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/_esm5/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var RejectedattributesComponent = (function () {
    function RejectedattributesComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.displayedColumns = ['source', 'mapped', 'delete'];
    }
    RejectedattributesComponent.prototype.ngOnInit = function () {
        var rows = [];
        for (var _i = 0, _a = Array.from(Object.keys(this.attributes)); _i < _a.length; _i++) {
            var p = _a[_i];
            rows.push(new __WEBPACK_IMPORTED_MODULE_6__row__["a" /* Row */](p));
        }
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_6__row__["b" /* RowDataSource */](rows);
    };
    RejectedattributesComponent.prototype.addRow = function () {
        this.dataSource.addRow();
    };
    RejectedattributesComponent.prototype.doChange = function (row, val) {
        this.attributes[val] = this.attributes[row.key];
        delete this.attributes[row.key];
        row.key = val;
    };
    RejectedattributesComponent.prototype.delete = function (row) {
        delete this.attributes[row.key];
        this.dataSource.removeRow(row);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Map)
    ], RejectedattributesComponent.prototype, "attributes", void 0);
    RejectedattributesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-rejectedattributes',
            template: __webpack_require__("../../../../../src/app/form/rejectedattributes/rejectedattributes.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/rejectedattributes/rejectedattributes.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], RejectedattributesComponent);
    return RejectedattributesComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/reqhandlers/reqhandlers.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.requiredHandlers\"\n           [placeholder]=\"messages.services_form_label_requiredHandlers\"\n           [ngModel]=\"data.service.requiredHandlers\"\n           (ngModelChange)=\"data.service.requiredHandlers = $event.split(',')\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"services.form.tooltip.requiredHandlers\"\n           [matTooltip]=\"messages.services_form_tooltip_requiredHandlers\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/reqhandlers/reqhandlers.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReqhandlersComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ReqhandlersComponent = (function () {
    function ReqhandlersComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ReqhandlersComponent.prototype.ngOnInit = function () {
    };
    ReqhandlersComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-reqhandlers',
            template: __webpack_require__("../../../../../src/app/form/reqhandlers/reqhandlers.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], ReqhandlersComponent);
    return ReqhandlersComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/row.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Row; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return RowDataSource; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var Row = (function () {
    function Row(key) {
        this.key = key;
    }
    return Row;
}());

var RowDataSource = (function (_super) {
    __extends(RowDataSource, _super);
    function RowDataSource() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    RowDataSource.prototype.addRow = function (row) {
        this.data.push(row ? row : new Row(''));
        this._updateChangeSubscription();
    };
    RowDataSource.prototype.removeRow = function (row) {
        this.data.splice(this.data.indexOf(row), 1);
        this._updateChangeSubscription();
    };
    return RowDataSource;
}(__WEBPACK_IMPORTED_MODULE_0__angular_material__["y" /* MatTableDataSource */]));



/***/ }),

/***/ "../../../../../src/app/form/samlclient/metadata/metadata.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/samlclient/metadata/metadata.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput required\n           i18n-placeholder=\"services.form.label.saml.metadata.location\"\n           [placeholder]=\"messages.services_form_label_saml_metadata_location\"\n           [(ngModel)]=\"service.metadataLocation\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.metadata.location\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_metadata_location\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.metadata.maximumvalidity\"\n           [placeholder]=\"messages.services_form_label_saml_metadata_maximumvalidity\"\n           [(ngModel)]=\"service.metadataMaxValidity\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.metadata.maximumvalidity\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_metadata_maximumvalidity\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.metadata.signaturepublickeylocation\"\n           [placeholder]=\"messages.services_form_label_saml_metadata_signaturepublickeylocation\"\n           [(ngModel)]=\"service.metadataSignatureLocation\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.metadata.signaturepublickeylocation\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_metadata_signaturepublickeylocation\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           placeholder=\"Metadata Expiration Duration\"\n           [(ngModel)]=\"service.metadataExpirationDuration\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            matTooltip=\"If defined, will expire metadata in the cache after the indicated duration which will force CAS to retrieve and resolve the metadata again.\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.metadata.pattern\"\n           [placeholder]=\"messages.services_form_label_saml_metadata_pattern\"\n           [(ngModel)]=\"service.metadataCriteriaPattern\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.metadata.pattern\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_metadata_pattern\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.saml.metadata.dir\"\n                [placeholder]=\"messages.services_form_label_saml_metadata_dir\"\n                [(ngModel)]=\"service.metadataCriteriaDirection\">\n      <mat-option *ngFor=\"let opt of data.formData.samlDirections\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.metadata.dir\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_metadata_dir\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.saml.metadata.role\"\n                [placeholder]=\"messages.services_form_label_saml_metadata_role\"\n                [(ngModel)]=\"service.metadataCriteriaRoles\">\n      <mat-option *ngFor=\"let opt of data.formData.samlRoles\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.metadata.role\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_metadata_role\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.metadataCriteriaRemoveEmptyEntitiesDescriptors\">\n    <ng-container i18n=\"services.form.saml.removeEmptyEntities\">\n      {{ messages.services_form_label_saml_removeEmptyEntities }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.removeEmptyEntitities\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_removeEmptyEntities\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div style=\"padding-bottom: 10px;\">\n  <mat-checkbox [(ngModel)]=\"service.metadataCriteriaRemoveRolelessEntityDescriptors\">\n    <ng-container i18n=\"services.form.label.saml.removeRoleless\">\n      {{ messages.services_form_label_saml_removeRoleless }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.removeRoleless\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_removeRoleless\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/samlclient/metadata/metadata.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MetadataComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var MetadataComponent = (function () {
    function MetadataComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    MetadataComponent.prototype.ngOnInit = function () {
    };
    MetadataComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-metadata',
            template: __webpack_require__("../../../../../src/app/form/samlclient/metadata/metadata.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/samlclient/metadata/metadata.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], MetadataComponent);
    return MetadataComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/samlclient/nameid/nameid.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/samlclient/nameid/nameid.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.requiredNameIdFormat\"\n           [placeholder]=\" messages.services_form_label_saml_requiredNameIdFormat\"\n           [(ngModel)]=\"service.requiredNameIdFormat\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.requiredNameIdFormat\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_requiredNameIdFormat\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.serviceProviderNameQualifier\"\n           [placeholder]=\" messages.services_form_label_saml_serviceProviderNameQualifier\"\n           [(ngModel)]=\"service.serviceProviderNameIdQualifier\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.serviceProviderNameQualifier\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_serviceProviderNameQualifier\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.nameQualifier\"\n           [placeholder]=\" messages.services_form_label_saml_nameQualifier\"\n           [(ngModel)]=\"service.nameIdQualifier\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.nameQualifier\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_nameQualifier\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/samlclient/nameid/nameid.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NameidComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var NameidComponent = (function () {
    function NameidComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    NameidComponent.prototype.ngOnInit = function () {
    };
    NameidComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-nameid',
            template: __webpack_require__("../../../../../src/app/form/samlclient/nameid/nameid.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/samlclient/nameid/nameid.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], NameidComponent);
    return NameidComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/samlclient/optional/optional.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/samlclient/optional/optional.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-checkbox [(ngModel)]=\"service.skipGeneratingAssertionNameId\">\n    <ng-container i18n=\"services.form.label.saml.skipAssertionNameId\">\n      {{ messages.services_form_label_saml_skipAssertionNameId }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.skipAssertionNameID\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_skipAssertioNameId\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.skipGeneratingSubjectConfirmationInResponseTo\">\n    <ng-container i18n=\"services.form.label.saml.skipInResponseTo\">\n      {{ messages.services_form_label_saml_skipInResponseTo }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.skipInResponseTo\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_skipInResponseTo\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.skipGeneratingSubjectConfirmationNotOnOrAfter\">\n    <ng-container i18n=\"services.form.label.saml.skipNotOnOrAfter\">\n      {{ messages.services_form_label_saml_skipNotOnOrAfter }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.skipNotOnOrAfter\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_skipNotOnOrAfter\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.skipGeneratingSubjectConfirmationRecipient\">\n    <ng-container i18n=\"services.form.label.saml.skipRecipient\">\n      {{ messages.services_form_label_saml_skipRecipient }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.skipRecipient\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_skipRecipient\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.skipGeneratingSubjectConfirmationNotBefore\">\n    <ng-container i18n=\"services.form.label.saml.skipNotBefore\">\n      {{ messages.services_form_label_saml_skipNotBefore }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.skipNotBefore\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_skipNotBefore\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/samlclient/optional/optional.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OptionalComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var OptionalComponent = (function () {
    function OptionalComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    OptionalComponent.prototype.ngOnInit = function () {
    };
    OptionalComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-optional',
            template: __webpack_require__("../../../../../src/app/form/samlclient/optional/optional.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/samlclient/optional/optional.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], OptionalComponent);
    return OptionalComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/samlclient/samlclient.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5 i18n>Saml Client - Metadata</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-metadata></app-metadata>\n  </div>\n</mat-card>\n\n<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5 i18n>SAML Client - Security</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-security></app-security>\n  </div>\n</mat-card>\n\n<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5 i18n>SAML Client - Optional Fields</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-optional></app-optional>\n  </div>\n</mat-card>\n\n<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5 i18n>SAML Client - Name ID</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-nameid></app-nameid>\n  </div>\n</mat-card>\n\n<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>SAML Attribute Name Formats</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-samlservicespane></app-samlservicespane>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/samlclient/samlclient.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SamlclientComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SamlclientComponent = (function () {
    function SamlclientComponent() {
    }
    SamlclientComponent.prototype.ngOnInit = function () {
    };
    SamlclientComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-samlclient',
            template: __webpack_require__("../../../../../src/app/form/samlclient/samlclient.component.html")
        }),
        __metadata("design:paramtypes", [])
    ], SamlclientComponent);
    return SamlclientComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/samlclient/security/security.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/samlclient/security/security.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-checkbox [(ngModel)]=\"service.signAssertions\">\n    <ng-container i18n=\"services.form.label.saml.signassertions\">\n      {{ messages.services_form_label_saml_signassertions }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.signassertions\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_signassertions\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-checkbox [(ngModel)]=\"service.signResponses\">\n    <ng-container i18n=\"services.form.label.saml.signresponses\">\n      {{ messages.services_form_label_saml_signresponses }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.signresponses\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_signresponses\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div style=\"padding-bottom: 10px;\">\n  <mat-checkbox [(ngModel)]=\"service.encryptAssertions\">\n    <ng-container i18n=\"services.form.label.saml.encryptassertions\">\n      {{ messages.services_form_label_saml_encryptassertions }}\n    </ng-container>\n    <mat-icon style=\"font-size: medium\"\n              i18n-matTooltip=\"services.form.tooltip.saml.encrpytassertions\"\n              [matTooltip]=\"messages.services_form_tooltip_saml_encryptassertions\">help\n    </mat-icon>\n  </mat-checkbox>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.saml.signingCredentialType\"\n                [placeholder]=\"messages.services_form_label_saml_signingCredentialType\"\n                [(ngModel)]=\"service.signingCredentialType\">\n      <mat-option *ngFor=\"let opt of data.formData.samlCredentialTypes\" [value]=\"opt\">\n        {{ opt }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.signingCredentialType\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_signingCredentialType\">help\n  </mat-icon>\n</div>\n\n<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.saml.authenticationcontextclass\"\n           [placeholder]=\" messages.services_form_label_saml_authenticationcontextclass\"\n           [(ngModel)]=\"service.requiredAuthenticationContextClass\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n            i18n-matTooltip=\"services.form.tooltip.saml.authenticationcontextclass\"\n            [matTooltip]=\"messages.services_form_tooltip_saml_authenticationcontextclass\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/samlclient/security/security.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SecurityComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SecurityComponent = (function () {
    function SecurityComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    SecurityComponent.prototype.ngOnInit = function () {
    };
    SecurityComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-security',
            template: __webpack_require__("../../../../../src/app/form/samlclient/security/security.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/samlclient/security/security.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], SecurityComponent);
    return SecurityComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/samlservicespane/samlservicespane.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".nameWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.valueWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n}\n\n.actionWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 40px;\n          flex: 0 0 40px;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/samlservicespane/samlservicespane.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-table [dataSource]=\"dataSource\">\n\n  <ng-container cdkColumnDef=\"source\">\n    <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'nameWidth'\">Name</mat-header-cell>\n    <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n      <mat-form-field>\n        <input matInput #text\n               [ngModel]=\"row.key\"\n               (change)=\"doChange(row,$event.target.value)\">\n      </mat-form-field>\n    </mat-cell>\n  </ng-container>\n\n  <ng-container cdkColumnDef=\"mapped\">\n    <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'valueWidth'\">Value</mat-header-cell>\n    <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'valueWidth'\">\n      <mat-form-field>\n        <mat-select [(ngModel)]=\"data.service.attributeNameFormats[row.key]\">\n          <mat-option *ngFor=\"let item of data.formData.attributeNameFormats\" [value]=\"item\">\n            {{item}}\n          </mat-option>\n        </mat-select>\n      </mat-form-field>\n    </mat-cell>\n  </ng-container>\n\n  <ng-container cdkColumnDef=\"delete\">\n    <mat-header-cell *cdkHeaderCellDef [ngClass]=\"'actionWidth'\"></mat-header-cell>\n    <mat-cell *cdkCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n      <button mat-icon-button (click)=\"delete(row)\"><mat-icon style=\"font-size: medium\">delete</mat-icon></button>\n    </mat-cell>\n  </ng-container>\n\n  <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n  <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n</mat-table>\n<div style=\"height:25px;padding-top: 5px;\">\n  <button mat-mini-fab (click)=\"addRow()\" style=\"float:right;\">+</button>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/samlservicespane/samlservicespane.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SamlservicespaneComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__util_util__ = __webpack_require__("../../../../../src/app/util/util.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SamlservicespaneComponent = (function () {
    function SamlservicespaneComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.displayedColumns = ['source', 'mapped', 'delete'];
    }
    SamlservicespaneComponent.prototype.ngOnInit = function () {
        var service = this.data.service;
        var rows = [];
        if (__WEBPACK_IMPORTED_MODULE_3__util_util__["a" /* Util */].isEmpty(service.attributeNameFormats)) {
            service.attributeNameFormats = new Map();
        }
        for (var _i = 0, _a = Array.from(Object.keys(service.attributeNameFormats)); _i < _a.length; _i++) {
            var p = _a[_i];
            rows.push(new __WEBPACK_IMPORTED_MODULE_4__row__["a" /* Row */](p));
        }
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_4__row__["b" /* RowDataSource */](rows);
    };
    SamlservicespaneComponent.prototype.addRow = function () {
        this.dataSource.addRow();
    };
    SamlservicespaneComponent.prototype.doChange = function (row, val) {
        var service = this.data.service;
        service.attributeNameFormats[val] = service.attributeNameFormats[row.key];
        delete service.attributeNameFormats[row.key];
        row.key = val;
    };
    SamlservicespaneComponent.prototype.delete = function (row) {
        var service = this.data.service;
        delete service.attributeNameFormats[row.key];
        this.dataSource.removeRow(row);
    };
    SamlservicespaneComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-samlservicespane',
            template: __webpack_require__("../../../../../src/app/form/samlservicespane/samlservicespane.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/samlservicespane/samlservicespane.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], SamlservicespaneComponent);
    return SamlservicespaneComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/servicedesc/servicedesc.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <textarea matInput rows=\"5\"\n              i18n-placeholder=\"services.form.label.description\"\n              [placeholder]=\"messages.services_form_label_description\"\n              [(ngModel)]=\"data.service.description\">\n    </textarea>\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium\"\n           i18n-matTooltip=\"servcies.form.tooltip.description\"\n          [matTooltip]=\"messages.services_form_tooltip_description\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/servicedesc/servicedesc.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServicedescComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ServicedescComponent = (function () {
    function ServicedescComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ServicedescComponent.prototype.ngOnInit = function () {
    };
    ServicedescComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-servicedesc',
            template: __webpack_require__("../../../../../src/app/form/servicedesc/servicedesc.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], ServicedescComponent);
    return ServicedescComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/serviceid/serviceid.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput i18n-placeholder required\n           [placeholder]=\"placeholder()\"\n           [(ngModel)]=\"data.service.serviceId\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium;\"\n           i18n-matTooltip=\"services.form.label.serviceId\"\n           [matTooltip]=\"tooltip()\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/serviceid/serviceid.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServiceidComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__domain_saml_service__ = __webpack_require__("../../../../../src/domain/saml-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domain_oauth_service__ = __webpack_require__("../../../../../src/domain/oauth-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__domain_wsed_service__ = __webpack_require__("../../../../../src/domain/wsed-service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var ServiceidComponent = (function () {
    function ServiceidComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ServiceidComponent.prototype.ngOnInit = function () {
        this.isSaml = __WEBPACK_IMPORTED_MODULE_3__domain_saml_service__["a" /* SamlRegisteredService */].instanceOf(this.data.service);
    };
    ServiceidComponent.prototype.placeholder = function () {
        if (__WEBPACK_IMPORTED_MODULE_3__domain_saml_service__["a" /* SamlRegisteredService */].instanceOf(this.data.service)) {
            return this.messages.services_form_label_entityId;
        }
        else if (__WEBPACK_IMPORTED_MODULE_4__domain_oauth_service__["b" /* OidcRegisteredService */].instanceOf(this.data.service) ||
            __WEBPACK_IMPORTED_MODULE_4__domain_oauth_service__["a" /* OAuthRegisteredService */].instanceOf(this.data.service)) {
            return this.messages.services_form_label_redirect_url;
        }
        else if (__WEBPACK_IMPORTED_MODULE_5__domain_wsed_service__["a" /* WSFederationRegisterdService */].instanceOf(this.data.service)) {
            return this.messages.services_form_label_consumer_url;
        }
        else {
            return this.messages.services_form_label_serviceId;
        }
    };
    ServiceidComponent.prototype.tooltip = function () {
        if (__WEBPACK_IMPORTED_MODULE_3__domain_saml_service__["a" /* SamlRegisteredService */].instanceOf(this.data.service)) {
            return this.messages.services_form_tooltip_entityId;
        }
        else if (__WEBPACK_IMPORTED_MODULE_4__domain_oauth_service__["b" /* OidcRegisteredService */].instanceOf(this.data.service) ||
            __WEBPACK_IMPORTED_MODULE_4__domain_oauth_service__["a" /* OAuthRegisteredService */].instanceOf(this.data.service)) {
            return this.messages.services_form_tooltip_redirect_url;
        }
        else if (__WEBPACK_IMPORTED_MODULE_5__domain_wsed_service__["a" /* WSFederationRegisterdService */].instanceOf(this.data.service)) {
            return this.messages.services_form_tooltip_consumer_url;
        }
        else {
            return this.messages.services_form_tooltip_serviceId;
        }
    };
    ServiceidComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-serviceid',
            template: __webpack_require__("../../../../../src/app/form/serviceid/serviceid.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], ServiceidComponent);
    return ServiceidComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/servicename/servicename.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput required\n           i18n-placeholder=\"services.form.label.name\"\n           [placeholder]=\"messages.services_form_label_name\"\n           [(ngModel)]=\"data.service.name\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium;\"\n           i18n-matTooltip=\"services.form.tooltip.name\"\n           [matTooltip]=\"messages.services_form_tooltip_name\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/servicename/servicename.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServicenameComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ServicenameComponent = (function () {
    function ServicenameComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ServicenameComponent.prototype.ngOnInit = function () {
    };
    ServicenameComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-servicename',
            template: __webpack_require__("../../../../../src/app/form/servicename/servicename.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], ServicenameComponent);
    return ServicenameComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/servicetype/servicetype.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <mat-select i18n-placeholder=\"services.form.label.type\"\n               [placeholder]=\"messages.services_form_label_type\"\n               [(ngModel)]=\"type\"\n               (selectionChange)=\"changeType()\">\n      <mat-option *ngFor=\"let opt of data.formData.serviceTypes; let i = index\" [value]=\"opt.value\">\n        {{ opt.display }}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/servicetype/servicetype.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServicetypeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_registered_service__ = __webpack_require__("../../../../../src/domain/registered-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__ = __webpack_require__("../../../../../src/domain/oauth-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__domain_saml_service__ = __webpack_require__("../../../../../src/domain/saml-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__domain_wsed_service__ = __webpack_require__("../../../../../src/domain/wsed-service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var Type;
(function (Type) {
    Type["CAS"] = "cas";
    Type["OAUTH"] = "oauth";
    Type["SAML"] = "saml";
    Type["OIDC"] = "oidc";
    Type["WS_FED"] = "wsfed";
})(Type || (Type = {}));
var ServicetypeComponent = (function () {
    function ServicetypeComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ServicetypeComponent.prototype.ngOnInit = function () {
        if (__WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__["a" /* OAuthRegisteredService */].instanceOf(this.data.service)) {
            this.type = Type.OAUTH;
        }
        else if (__WEBPACK_IMPORTED_MODULE_5__domain_wsed_service__["a" /* WSFederationRegisterdService */].instanceOf(this.data.service)) {
            this.type = Type.WS_FED;
        }
        else if (__WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__["b" /* OidcRegisteredService */].instanceOf(this.data.service)) {
            this.type = Type.OIDC;
        }
        else if (__WEBPACK_IMPORTED_MODULE_4__domain_saml_service__["a" /* SamlRegisteredService */].instanceOf(this.data.service)) {
            this.type = Type.SAML;
        }
        else {
            this.type = Type.CAS;
        }
    };
    ServicetypeComponent.prototype.changeType = function () {
        switch (this.type) {
            case Type.CAS:
                this.data.service = new __WEBPACK_IMPORTED_MODULE_2__domain_registered_service__["a" /* RegexRegisteredService */](this.data.service);
                break;
            case Type.OAUTH:
                this.data.service = new __WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__["a" /* OAuthRegisteredService */](this.data.service);
                break;
            case Type.OIDC:
                this.data.service = new __WEBPACK_IMPORTED_MODULE_3__domain_oauth_service__["b" /* OidcRegisteredService */](this.data.service);
                break;
            case Type.SAML:
                this.data.service = new __WEBPACK_IMPORTED_MODULE_4__domain_saml_service__["a" /* SamlRegisteredService */](this.data.service);
                break;
            case Type.WS_FED:
                this.data.service = new __WEBPACK_IMPORTED_MODULE_5__domain_wsed_service__["a" /* WSFederationRegisterdService */](this.data.service);
                break;
        }
    };
    ServicetypeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-servicetype',
            template: __webpack_require__("../../../../../src/app/form/servicetype/servicetype.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_6__data__["a" /* Data */]])
    ], ServicetypeComponent);
    return ServicetypeComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/tab-accessstrategy/tab-accessstrategy.component.html":
/***/ (function(module, exports) {

module.exports = "<form #accessForm=\"ngForm\">\n  <app-access-strategy></app-access-strategy>\n  <button type=\"submit\" display=\"display:none;\" #submit></button>\n</form>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-accessstrategy/tab-accessstrategy.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabAccessstrategyComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabAccessstrategyComponent = (function (_super) {
    __extends(TabAccessstrategyComponent, _super);
    function TabAccessstrategyComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabAccessstrategyComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-accessstratefy',
            template: __webpack_require__("../../../../../src/app/form/tab-accessstrategy/tab-accessstrategy.component.html")
        })
    ], TabAccessstrategyComponent);
    return TabAccessstrategyComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-advanced/tab-advanced.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <form #advancedForm=\"ngForm\">\n    <mat-card class=\"tabCard\">\n      <mat-card-title>\n        <h5>Advanced</h5>\n      </mat-card-title>\n      <div class=\"cardContent\">\n        <app-evalorder></app-evalorder>\n        <app-reqhandlers></app-reqhandlers>\n      </div>\n    </mat-card>\n    <mat-card class=\"tabCard\">\n      <mat-card-title>\n          <h5>Public Key Options</h5>\n      </mat-card-title>\n      <div class=\"cardContent\">\n        <app-pubkey></app-pubkey>\n      </div>\n    </mat-card>\n    <button type=\"submit\" style=\"display:none;\" #submit></button>\n  </form>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-advanced/tab-advanced.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabAdvancedComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabAdvancedComponent = (function (_super) {
    __extends(TabAdvancedComponent, _super);
    function TabAdvancedComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabAdvancedComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-advanced',
            template: __webpack_require__("../../../../../src/app/form/tab-advanced/tab-advanced.component.html")
        })
    ], TabAdvancedComponent);
    return TabAdvancedComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-attrrelease/tab-attrrelease.component.html":
/***/ (function(module, exports) {

module.exports = "<form #attrReleaseForm=\"ngForm\">\n  <app-attribute-release></app-attribute-release>\n  <button type=\"submit\" style=\"display:none;\" #submit></button>\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-attrrelease/tab-attrrelease.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabAttrreleaseComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabAttrreleaseComponent = (function (_super) {
    __extends(TabAttrreleaseComponent, _super);
    function TabAttrreleaseComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabAttrreleaseComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-attrrelease',
            template: __webpack_require__("../../../../../src/app/form/tab-attrrelease/tab-attrrelease.component.html")
        })
    ], TabAttrreleaseComponent);
    return TabAttrreleaseComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-base.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabBaseComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_switchMap__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/switchMap.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TabBaseComponent = (function () {
    function TabBaseComponent(data, changeRef) {
        this.data = data;
        this.changeRef = changeRef;
    }
    TabBaseComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (this.data.submitted) {
            this.submit.nativeElement.click();
        }
        this.sub = this.data.save.asObservable().subscribe(function () {
            _this.submit.nativeElement.click();
        });
    };
    TabBaseComponent.prototype.ngOnDestroy = function () {
        this.sub.unsubscribe();
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])('submit'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["u" /* ElementRef */])
    ], TabBaseComponent.prototype, "submit", void 0);
    TabBaseComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-base',
            template: ''
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */],
            __WEBPACK_IMPORTED_MODULE_0__angular_core__["k" /* ChangeDetectorRef */]])
    ], TabBaseComponent);
    return TabBaseComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/tab-basics/tab-basics.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Basics</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <form #basicsForm=\"ngForm\">\n      <app-enabled></app-enabled>\n      <app-servicetype></app-servicetype>\n      <app-serviceid></app-serviceid>\n      <app-servicename></app-servicename>\n      <app-servicedesc></app-servicedesc>\n      <app-themeid></app-themeid>\n      <button type=\"submit\" style=\"display:none;\" #submit></button>\n    </form>\n  </div>\n</mat-card>\n<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Reference Links</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <app-logo></app-logo>\n    <app-linkrefs></app-linkrefs>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-basics/tab-basics.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabBasicsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_switchMap__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/switchMap.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var TabBasicsComponent = (function (_super) {
    __extends(TabBasicsComponent, _super);
    function TabBasicsComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabBasicsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-basics',
            template: __webpack_require__("../../../../../src/app/form/tab-basics/tab-basics.component.html")
        })
    ], TabBasicsComponent);
    return TabBasicsComponent;
}(__WEBPACK_IMPORTED_MODULE_2__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-contacts/tab-contacts.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/tab-contacts/tab-contacts.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5 i18n>Contacts</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <form #contactsForm=\"ngForm\">\n      <app-contacts [form]=\"contactsForm\"></app-contacts>\n      <button type=\"submit\" style=\"display: none;\" #submit></button>\n    </form>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-contacts/tab-contacts.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabContactsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabContactsComponent = (function (_super) {
    __extends(TabContactsComponent, _super);
    function TabContactsComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabContactsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-contacts',
            template: __webpack_require__("../../../../../src/app/form/tab-contacts/tab-contacts.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/tab-contacts/tab-contacts.component.css")]
        })
    ], TabContactsComponent);
    return TabContactsComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-expiration/tab-expiration.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/tab-expiration/tab-expiration.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Expiration</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <form #expirationForm=\"ngForm\">\n      <app-expiration></app-expiration>\n      <button type=\"submit\" style=\"display: none;\" #submit></button>\n    </form>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-expiration/tab-expiration.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabExpirationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var TabExpirationComponent = (function () {
    function TabExpirationComponent() {
    }
    TabExpirationComponent.prototype.ngOnInit = function () {
    };
    TabExpirationComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-expiration',
            template: __webpack_require__("../../../../../src/app/form/tab-expiration/tab-expiration.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/tab-expiration/tab-expiration.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], TabExpirationComponent);
    return TabExpirationComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/tab-logout/tab-logout.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Logout Options</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <form #logoutForm=\"ngForm\">\n      <app-logout></app-logout>\n      <app-logouttypeeval></app-logouttypeeval>\n      <button type=\"submit\" style=\"display:none;\" #submit></button>\n    </form>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-logout/tab-logout.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabLogoutComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabLogoutComponent = (function (_super) {
    __extends(TabLogoutComponent, _super);
    function TabLogoutComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabLogoutComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-logout',
            template: __webpack_require__("../../../../../src/app/form/tab-logout/tab-logout.component.html")
        })
    ], TabLogoutComponent);
    return TabLogoutComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-mulitauth/tab-mulitauth.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Multifactor Policy</h5>\n  </mat-card-title>\n  <mat-card-content>\n    <div class=\"cardContent\">\n      <form #multiAuthForm=\"ngForm\">\n        <app-multiauthpane></app-multiauthpane>\n        <button type=\"submit\" style=\"display:none;\" #submit></button>\n      </form>\n    </div>\n  </mat-card-content>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-mulitauth/tab-mulitauth.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabMulitauthComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabMulitauthComponent = (function (_super) {
    __extends(TabMulitauthComponent, _super);
    function TabMulitauthComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabMulitauthComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-mulitauth',
            template: __webpack_require__("../../../../../src/app/form/tab-mulitauth/tab-mulitauth.component.html")
        })
    ], TabMulitauthComponent);
    return TabMulitauthComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-oauth/tab-oauth.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/tab-oauth/tab-oauth.component.html":
/***/ (function(module, exports) {

module.exports = "<form #oauthForm=\"ngForm\">\n  <app-oauthclient></app-oauthclient>\n  <button type=\"submit\" style=\"display: none;\" #submit></button>\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-oauth/tab-oauth.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabOauthComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabOauthComponent = (function (_super) {
    __extends(TabOauthComponent, _super);
    function TabOauthComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabOauthComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-oauth',
            template: __webpack_require__("../../../../../src/app/form/tab-oauth/tab-oauth.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/tab-oauth/tab-oauth.component.css")]
        })
    ], TabOauthComponent);
    return TabOauthComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-oidc/tab-oidc.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/tab-oidc/tab-oidc.component.html":
/***/ (function(module, exports) {

module.exports = "<form #oidcForm=\"ngForm\">\n  <app-oidcclient></app-oidcclient>\n  <button type=\"submit\" style=\"display: none;\" #submit></button>\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-oidc/tab-oidc.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabOIDCComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabOIDCComponent = (function (_super) {
    __extends(TabOIDCComponent, _super);
    function TabOIDCComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabOIDCComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-oidc',
            template: __webpack_require__("../../../../../src/app/form/tab-oidc/tab-oidc.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/tab-oidc/tab-oidc.component.css")]
        })
    ], TabOIDCComponent);
    return TabOIDCComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-properties/tab-properties.component.html":
/***/ (function(module, exports) {

module.exports = "<form #propertiesForm=\"ngForm\">\n  <app-propertiespane></app-propertiespane>\n  <button type=\"submit\" style=\"display: none;\" #submit></button>\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-properties/tab-properties.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabPropertiesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabPropertiesComponent = (function (_super) {
    __extends(TabPropertiesComponent, _super);
    function TabPropertiesComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabPropertiesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-properties',
            template: __webpack_require__("../../../../../src/app/form/tab-properties/tab-properties.component.html")
        })
    ], TabPropertiesComponent);
    return TabPropertiesComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-proxy/tab-proxy.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Proxy Options</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <form #proxyForm=\"ngForm\">\n      <app-proxy></app-proxy>\n      <button type=\"submit\" style=\"display: none;\" #submit></button>\n    </form>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-proxy/tab-proxy.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabProxyComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabProxyComponent = (function (_super) {
    __extends(TabProxyComponent, _super);
    function TabProxyComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabProxyComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-proxy',
            template: __webpack_require__("../../../../../src/app/form/tab-proxy/tab-proxy.component.html")
        })
    ], TabProxyComponent);
    return TabProxyComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-saml/tab-saml.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/tab-saml/tab-saml.component.html":
/***/ (function(module, exports) {

module.exports = "<form #samlForm=\"ngForm\">\n  <app-samlclient></app-samlclient>\n  <button type=\"submit\" style=\"display: none\" #submit></button>\n</form>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-saml/tab-saml.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabSamlComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabSamlComponent = (function (_super) {
    __extends(TabSamlComponent, _super);
    function TabSamlComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabSamlComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-saml',
            template: __webpack_require__("../../../../../src/app/form/tab-saml/tab-saml.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/tab-saml/tab-saml.component.css")]
        })
    ], TabSamlComponent);
    return TabSamlComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-usernameattr/tab-usernameattr.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>Username Options</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <form #userAttrForm=\"ngForm\">\n      <app-uidattrs></app-uidattrs>\n      <button type=\"submit\" style=\"display: none;\" #submit></button>\n    </form>\n  </div>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-usernameattr/tab-usernameattr.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabUsernameattrComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabUsernameattrComponent = (function (_super) {
    __extends(TabUsernameattrComponent, _super);
    function TabUsernameattrComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabUsernameattrComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-usernameattr',
            template: __webpack_require__("../../../../../src/app/form/tab-usernameattr/tab-usernameattr.component.html")
        })
    ], TabUsernameattrComponent);
    return TabUsernameattrComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/tab-wsfed/tab-wsfed.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/tab-wsfed/tab-wsfed.component.html":
/***/ (function(module, exports) {

module.exports = "<form #wsForm=\"ngForm\">\n <app-wsfedclient></app-wsfedclient>\n <button type=\"submit\"style=\"display:none\" #submit></button>\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/form/tab-wsfed/tab-wsfed.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TabWsfedComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__tab_base__ = __webpack_require__("../../../../../src/app/form/tab-base.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TabWsfedComponent = (function (_super) {
    __extends(TabWsfedComponent, _super);
    function TabWsfedComponent() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    TabWsfedComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-tab-wsfed',
            template: __webpack_require__("../../../../../src/app/form/tab-wsfed/tab-wsfed.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/tab-wsfed/tab-wsfed.component.css")]
        })
    ], TabWsfedComponent);
    return TabWsfedComponent;
}(__WEBPACK_IMPORTED_MODULE_1__tab_base__["a" /* TabBaseComponent */]));



/***/ }),

/***/ "../../../../../src/app/form/themeid/themeid.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <mat-form-field class=\"textInput\">\n    <input matInput\n           i18n-placeholder=\"services.form.label.theme\"\n           [placeholder]=\"messages.services_form_label_theme\"\n           [(ngModel)]=\"data.service.theme\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium;\"\n           i18n-matTooltip=\"services.form.tooltip.theme\"\n           [matTooltip]=\"messages.services_form_tooltip_theme\">help\n  </mat-icon>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/themeid/themeid.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ThemeidComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ThemeidComponent = (function () {
    function ThemeidComponent(messages, data) {
        this.messages = messages;
        this.data = data;
    }
    ThemeidComponent.prototype.ngOnInit = function () {
    };
    ThemeidComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-themeid',
            template: __webpack_require__("../../../../../src/app/form/themeid/themeid.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], ThemeidComponent);
    return ThemeidComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/uidattrs/uidattrs.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-radio-group [(ngModel)]=\"type\" (change)=\"changeType()\">\n\n  <mat-radio-button [value]=\"TYPE.DEFAULT\">\n    <ng-container i18n=\"services.form.label.uap.default\">\n      {{ messages.services_form_label_uap_default }}\n    </ng-container>\n  </mat-radio-button>\n\n  <mat-radio-button [value]=\"TYPE.ANONYMOUS\">\n    <ng-container i18n=\"services.form.label.uap.anon\">\n      {{ messages.services_form_label_uap_anon }}\n    </ng-container>\n  </mat-radio-button>\n\n  <mat-radio-button [value]=\"TYPE.PRINCIPAL_ATTRIBUTE\">\n    <ng-container i18n=\"services.form.label.uap.principleAtt\">\n      {{ messages.services_form_label_uap_principleAtt }}\n    </ng-container>\n  </mat-radio-button>\n\n</mat-radio-group>\n\n<div *ngIf=\"type == TYPE.ANONYMOUS\">\n  <mat-form-field class=\"textInput\">\n    <input matInput required\n           i18n-placeholder=\"services.form.label.uap.saltSetting\"\n           [placeholder]=\"messages.services_form_label_uap_saltSetting\"\n           [(ngModel)]=\"data.service.usernameAttributeProvider.persistentIdGenerator.salt\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium;\"\n           i18n-myTooltip=\"services.form.tooltip.uap.saltSetting\"\n           [matTooltip]=\"messages.services_form_tooltip_uap_saltSetting\">help\n  </mat-icon>\n  <mat-form-field class=\"textInput\">\n    <input matInput [matAutocomplete]=\"auto\"\n           i18n-placeholder=\"services.form.label.uap.anonAttribute\"\n           [placeholder]=\"messages.services_form_label_uap_anonAttribute\"\n           [(ngModel)]=\"data.service.usernameAttributeProvider.persistentIdGenerator.attribute\">\n  </mat-form-field>\n  <mat-icon style=\"font-size: medium;\"\n           i18n-myTooltip=\"services.form.tooltip.uap.anonAttribute\"\n           [matTooltip]=\"messages.services_form_tooltip_uap_anonAttribute\">help\n  </mat-icon>\n</div>\n\n<div *ngIf=\"type == TYPE.PRINCIPAL_ATTRIBUTE\">\n\n  <div>\n    <mat-form-field class=\"textInput\">\n      <input matInput required [matAutocomplete]=\"auto\"\n             i18n-placeholder=\"services.form.label.uap.usernameAttribute\"\n             [placeholder]=\"messages.services_form_label_uap_usernameAttribute\"\n             [(ngModel)]=\"data.service.usernameAttributeProvider.usernameAttribute\">\n    </mat-form-field>\n    <mat-icon style=\"font-size: medium;\"\n             i18n-matTooltip=\"services.form.tooltip.uap.usernameAttribute\"\n             [matTooltip]=\"messages.services_form_tooltip_uap_usernameAttribute\">help\n    </mat-icon>\n  </div>\n\n  <div>\n    <mat-checkbox [(ngModel)]=\"data.service.usernameAttributeProvider.encryptUserName\">\n      <ng-container i18n>\n        Encrypt Username\n      </ng-container>\n    </mat-checkbox>\n    <mat-icon style=\"font-size: medium;\"\n             i18n-matTooltip=\"encpytUsername\"\n             matTooltip=\"If checked the username attribute will be encrypted using the defined public key for the service\">help\n    </mat-icon>\n  </div>\n\n  <div>\n    <mat-form-field class=\"textInput\">\n      <mat-select i18n-placeholder=\"services.form.label.uap.canonicalizationMode\"\n                  [placeholder]=\"messages.services_form_label_uap_canonicalizationMode\"\n                  [(ngModel)]=\"data.service.usernameAttributeProvider.canonicalizationMode\">\n        <mat-option *ngFor=\"let opt of data.formData.canonicalizationModes\" [value]=\"opt\">\n          {{ opt }}\n        </mat-option>\n      </mat-select>\n    </mat-form-field>\n  </div>\n\n</div>\n\n<mat-autocomplete style=\"width:300px\" #auto=\"matAutocomplete\">\n  <mat-option *ngFor=\"let opt of formData.availableAttributes\" [value]=\"opt\">{{ opt }}</mat-option>\n</mat-autocomplete>\n"

/***/ }),

/***/ "../../../../../src/app/form/uidattrs/uidattrs.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UidattrsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__ = __webpack_require__("../../../../../src/domain/attribute-provider.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var Type;
(function (Type) {
    Type[Type["DEFAULT"] = 0] = "DEFAULT";
    Type[Type["PRINCIPAL_ATTRIBUTE"] = 1] = "PRINCIPAL_ATTRIBUTE";
    Type[Type["ANONYMOUS"] = 2] = "ANONYMOUS";
})(Type || (Type = {}));
var UidattrsComponent = (function () {
    function UidattrsComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.TYPE = Type;
        this.formData = data.formData;
    }
    UidattrsComponent.prototype.ngOnInit = function () {
        if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__["b" /* DefaultRegisteredServiceUsernameProvider */].instanceOf(this.data.service.usernameAttributeProvider)) {
            this.type = Type.DEFAULT;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__["c" /* PrincipalAttributeRegisteredServiceUsernameProvider */].instanceOf(this.data.service.usernameAttributeProvider)) {
            this.type = Type.PRINCIPAL_ATTRIBUTE;
        }
        else if (__WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__["a" /* AnonymousRegisteredServiceUsernameProvider */].instanceOf(this.data.service.usernameAttributeProvider)) {
            this.type = Type.ANONYMOUS;
        }
    };
    UidattrsComponent.prototype.changeType = function () {
        switch (+this.type) {
            case Type.DEFAULT:
                this.data.service.usernameAttributeProvider = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__["b" /* DefaultRegisteredServiceUsernameProvider */]();
                break;
            case Type.PRINCIPAL_ATTRIBUTE:
                this.data.service.usernameAttributeProvider = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__["c" /* PrincipalAttributeRegisteredServiceUsernameProvider */]();
                break;
            case Type.ANONYMOUS:
                this.data.service.usernameAttributeProvider = new __WEBPACK_IMPORTED_MODULE_2__domain_attribute_provider__["a" /* AnonymousRegisteredServiceUsernameProvider */]();
                break;
        }
    };
    UidattrsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-uidattrs',
            template: __webpack_require__("../../../../../src/app/form/uidattrs/uidattrs.component.html")
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__data__["a" /* Data */]])
    ], UidattrsComponent);
    return UidattrsComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/wsfedattrrelpolocies/wsfedattrrelpolicies.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/wsfedattrrelpolocies/wsfedattrrelpolicies.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"panel panel-default\" *ngIf=\"!isEmpty(formData.availableAttributes)\">\n  <mat-table [dataSource]=\"dataSource\">\n\n    <ng-container cdkColumnDef=\"source\">\n      <mat-header-cell *cdkHeaderCellDef>\n        <ng-container i18n=\"services.form.label.attrRelease.policies.sourceAttribute\">\n          {{ messages.services_form_label_attrRelease_policies_sourceAttribute }}\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\"> {{ row.key }}</mat-cell>\n    </ng-container>\n\n    <ng-container cdkColumnDef=\"mapped\">\n      <mat-header-cell *cdkHeaderCellDef>\n        <ng-container i18n=\"services.form.label.attrRelease.policies.wsFedClaim\">\n          {{ messages.services_form_label_attrRelease_policies_wsFedClaim }}\n        </ng-container>\n        <mat-icon style=\"font-size: medium;\"\n                 i18n-matTooltip=\"services.form.tooltip.attrRelease.policies.returnWsMapped\"\n                 [matTooltip]=\"messages.services_form_tooltip_attrRelease_policies_returnWsMapped\">help\n        </mat-icon>\n      </mat-header-cell>\n      <mat-cell *cdkCellDef=\"let row\">\n        <mat-form-field>\n          <mat-select [(ngModel)]=\"data.service.attributeReleasePolicy.allowedAttributes[row.key]\">\n            <mat-option *ngFor=\"let item of data.formData.wsFederationClaims\" [value]=\"item\">{{ item }}</mat-option>\n          </mat-select>\n        </mat-form-field>\n      </mat-cell>\n    </ng-container>\n\n    <mat-header-row *cdkHeaderRowDef=\"displayedColumns\"></mat-header-row>\n    <mat-row *cdkRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n\n  </mat-table>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form/wsfedattrrelpolocies/wsfedattrrelpolicies.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WsfedattrrelpoliciesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__util_util__ = __webpack_require__("../../../../../src/app/util/util.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__row__ = __webpack_require__("../../../../../src/app/form/row.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var WsfedattrrelpoliciesComponent = (function () {
    function WsfedattrrelpoliciesComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.displayedColumns = ['source', 'mapped'];
        this.formData = data.formData;
    }
    WsfedattrrelpoliciesComponent.prototype.ngOnInit = function () {
        var attrPolicy = this.data.service.attributeReleasePolicy;
        var rows = [];
        if (__WEBPACK_IMPORTED_MODULE_3__util_util__["a" /* Util */].isEmpty(attrPolicy.allowedAttributes)) {
            attrPolicy.allowedAttributes = new Map();
        }
        this.formData.availableAttributes.forEach(function (k) {
            attrPolicy.allowedAttributes[k] = k;
        });
        for (var _i = 0, _a = Array.from(Object.keys(attrPolicy.allowedAttributes)); _i < _a.length; _i++) {
            var key = _a[_i];
            rows.push(new __WEBPACK_IMPORTED_MODULE_4__row__["a" /* Row */](key));
        }
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_4__row__["b" /* RowDataSource */](rows);
    };
    WsfedattrrelpoliciesComponent.prototype.isEmpty = function (data) {
        return !data || data.length === 0;
    };
    WsfedattrrelpoliciesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-wsfedattrrelpolicies',
            template: __webpack_require__("../../../../../src/app/form/wsfedattrrelpolocies/wsfedattrrelpolicies.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/wsfedattrrelpolocies/wsfedattrrelpolicies.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], WsfedattrrelpoliciesComponent);
    return WsfedattrrelpoliciesComponent;
}());



/***/ }),

/***/ "../../../../../src/app/form/wsfedclient/wsfedclient.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form/wsfedclient/wsfedclient.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"tabCard\">\n  <mat-card-title>\n    <h5>WS Federation Options</h5>\n  </mat-card-title>\n  <div class=\"cardContent\">\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput\n               i18n-placeholder=\"services.form.label.wsfed.realm\"\n               [placeholder]=\"messages.services_form_label_wsfed_realm\"\n               [(ngModel)]=\"service.realm\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium;\"\n               i18n-matTooltip=\"services.form.tooltip.wsfed.realm\"\n               [matTooltip]=\"messages.services_form_tooltip_wsfed_realm\">help\n      </mat-icon>\n    </div>\n\n    <div>\n      <mat-form-field class=\"textInput\">\n        <input matInput required\n               i18n-placeholder=\"services.form.label.wsfed.appliesTo\"\n               [placeholder]=\"messages.services_form_label_wsfed_appliesTo\"\n               [(ngModel)]=\"service.appliesTo\">\n      </mat-form-field>\n      <mat-icon style=\"font-size: medium\"\n               i18n-matTooltip=\"services.form.tooltip.wsfed.appliesTo\"\n               [matTooltip]=\"messages.services_form_tooltip_wsfed_appliesTo\">help\n      </mat-icon>\n    </div>\n  </div>\n</mat-card>\n\n"

/***/ }),

/***/ "../../../../../src/app/form/wsfedclient/wsfedclient.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WsfedclientComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__data__ = __webpack_require__("../../../../../src/app/form/data.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var WsfedclientComponent = (function () {
    function WsfedclientComponent(messages, data) {
        this.messages = messages;
        this.data = data;
        this.service = data.service;
    }
    WsfedclientComponent.prototype.ngOnInit = function () {
    };
    WsfedclientComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-wsfedclient',
            template: __webpack_require__("../../../../../src/app/form/wsfedclient/wsfedclient.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form/wsfedclient/wsfedclient.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__data__["a" /* Data */]])
    ], WsfedclientComponent);
    return WsfedclientComponent;
}());



/***/ }),

/***/ "../../../../../src/app/header/header.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".header {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  height:50px;\n  background-color: #153e50;\n  color: #ffffff;\n  border: none;\n  border-radius: 0;\n  margin-bottom: 0;\n  border-bottom: 1px solid #6ec066;\n  position: fixed;\n  width: 100%;\n  z-index: 1000;\n  top:0px;\n}\n\n.brand > img {\n  height: 25px;\n  vertical-align: middle;\n  margin-left:10px;\n  margin-right:10px;\n  border: 0;\n}\n\n.brand > h4 {\n  display: inline-block;\n  margin-top: 16px;\n  font-weight: normal;\n  color:#ffffff;\n}\n\n.searchbox {\n  -webkit-box-flex: 1;\n      -ms-flex: 1 1 auto;\n          flex: 1 1 auto;\n  text-align: center;\n  padding-top:11px;\n}\n\n.search {\n  max-width:400px;\n  min-width:100px;\n  width:100%;\n  height:30px;\n  color:#000000;\n  border:0;\n  opacity: .85;\n  text-indent: 5px;\n}\n\n.links {\n  padding-right:10px;\n  padding-top: 3px;\n  color:#ffffff;\n}\n\n.links > a {\n  padding-right:10px;\n  color: #ffffff;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/header/header.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"header\">\n  <div style=\"margin-right:10px;min-width:200px;max-width:200px;width:100%;\">\n    <a class=\"brand\" href=\"manage.html\" target=\"_self\" id=\"homepageUrlLink\">\n      <img src=\"images/logo_cas.png\" alt=\"apereo CAS logo\" />\n      <h4>\n        <ng-container i18n=\"management.services.header.apptitle\">\n          {{ messages.management_services_header_apptitle }}\n        </ng-container>\n      </h4>\n    </a>\n  </div>\n  <div class=\"searchbox\">\n    <input #search class=\"search\" placeholder=\"Search Services\" (keypress)=\"doSearch($event.target.value)\">\n  </div>\n  <div>\n    <button mat-button [matMenuTriggerFor]=\"links\">\n      <mat-icon>menu</mat-icon>\n    </button>\n  </div>\n</div>\n\n<mat-menu #links>\n  <button mat-menu-item *ngIf=\"type === 'DOMAIN' \" routerLink=\"/domains\">\n    <mat-icon>apps</mat-icon>\n    <span i18n>Domains</span>\n  </button>\n  <button *ngIf=\"type === 'DEFAULT'\" mat-menu-item routerLink=\"/services/defualt\">\n    <mat-icon>apps</mat-icon>\n    <span i18n>Services</span>\n  </button>\n  <button mat-menu-item routerLink=\"/form/-1\">\n    <mat-icon>add_circle</mat-icon>\n    <span i18n=\"managment.services.header.navitem.addNewService\">\n        {{ messages.management_services_header_navbar_navitem_addNewService }}\n      </span>\n  </button>\n  <button mat-menu-item target=\"_self\" id=\"logoutUrlLink\" (click)=\"logout()\">\n    <mat-icon>exit_to_app</mat-icon>\n    <ng-container i18n=\"management.services.header.navbar.navitem.logout\">\n      {{ messages.management_services_header_navbar_navitem_logout }}\n    </ng-container>\n  </button>\n\n"

/***/ }),

/***/ "../../../../../src/app/header/header.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HeaderComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__header_service__ = __webpack_require__("../../../../../src/app/header/header.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var HeaderComponent = (function () {
    function HeaderComponent(messages, router, location, service) {
        this.messages = messages;
        this.router = router;
        this.location = location;
        this.service = service;
    }
    HeaderComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.getMangerType().then(function (resp) { return _this.type = resp; });
    };
    HeaderComponent.prototype.doSearch = function (val) {
        this.router.navigate(['search', val]);
    };
    HeaderComponent.prototype.logout = function () {
        window.location.href = 'logout.html';
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])('search'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["u" /* ElementRef */])
    ], HeaderComponent.prototype, "search", void 0);
    HeaderComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-header',
            template: __webpack_require__("../../../../../src/app/header/header.component.html"),
            styles: [__webpack_require__("../../../../../src/app/header/header.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__angular_common__["f" /* Location */],
            __WEBPACK_IMPORTED_MODULE_4__header_service__["a" /* HeaderService */]])
    ], HeaderComponent);
    return HeaderComponent;
}());



/***/ }),

/***/ "../../../../../src/app/header/header.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HeaderService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__service__ = __webpack_require__("../../../../../src/app/service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var HeaderService = (function (_super) {
    __extends(HeaderService, _super);
    function HeaderService(http) {
        return _super.call(this, http) || this;
    }
    HeaderService.prototype.getMangerType = function () {
        return this.getText('managerType');
    };
    HeaderService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], HeaderService);
    return HeaderService;
}(__WEBPACK_IMPORTED_MODULE_0__service__["a" /* Service */]));



/***/ }),

/***/ "../../../../../src/app/init.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InitComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__header_header_service__ = __webpack_require__("../../../../../src/app/header/header.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var InitComponent = (function () {
    function InitComponent(router, messages, service) {
        this.router = router;
        this.messages = messages;
        this.service = service;
    }
    InitComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.getMangerType().then(function (resp) {
            if (resp === 'DOMAIN') {
                _this.router.navigate(['/domains']);
            }
            else {
                _this.router.navigate(['services', 'default']);
            }
        });
    };
    InitComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-init',
            template: ''
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__header_header_service__["a" /* HeaderService */]])
    ], InitComponent);
    return InitComponent;
}());



/***/ }),

/***/ "../../../../../src/app/messages.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Messages; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

/**
 * Created by tschmidt on 2/10/17.
 */
/* tslint:disable */
var Messages = (function () {
    function Messages() {
        // Welcome Screen Messages
        // Blocked Errors Page
        this.screen_blocked_header = 'Access Denied';
        this.screen_blocked_message = 'You are not authorized to access this resource. Contact your CAS administrator for more info.';
        // Logout Screen Messages
        this.screen_logout_header = 'Logout successful';
        this.screen_logout_success = 'You have successfully logged out of the CAS Management web application.';
        // SERVICES MANAGEMENT HEADER
        this.management_services_header_apptitle = 'CAS Management';
        this.management_services_header_navbar_navitem_addNewService = 'Add New Service';
        this.management_services_header_navbar_navitem_manageService = 'Manage Services';
        this.management_services_header_navbar_navitem_sessions = 'Sessions';
        this.management_services_header_navbar_navitem_logout = 'Log Out';
        // MANAGE SERVICES TABLE
        this.management_services_table_label_search = 'Search by Service ID, Name or Description';
        this.management_services_table_header_serviceName = 'Service Name';
        this.management_services_table_header_serviceId = 'Service URL';
        this.management_services_table_header_serviceDesc = 'Service Description';
        this.management_services_table_details_description = 'Full Description';
        this.management_services_table_details_proxyPolicy = 'Proxy Policy';
        this.management_services_table_details_attrPolicy = 'Attribute Policy Option';
        this.management_services_table_details_releaseCred = 'Release Credential';
        this.management_services_table_details_releaseProxy = 'Release Proxy ID';
        this.management_services_table_button_edit = 'Edit';
        this.management_services_table_button_duplicate = 'Duplicate';
        this.management_services_table_button_delete = 'Delete';
        this.management_services_table_modal_delete_header = 'Confirm Delete';
        this.management_services_table_modal_delete_msgPt1 = 'You are about to permanently delete';
        this.management_services_table_modal_delete_msgPt2 = 'Are you sure you wish to continue?';
        this.management_services_table_modal_commit_header = 'Commit to Repository';
        this.management_services_table_modal_commit_listheader = 'Services to be committed:';
        this.management_services_table_modal_commit_required = 'A commit message is required';
        this.management_services_table_modal_commit_placeholder = 'Enter a commit message';
        this.management_services_table_modal_button_commit = 'Commit';
        this.management_services_table_modal_button_cancel = 'Cancel';
        this.management_services_table_modal_button_delete = 'Delete';
        this.management_services_table_modal_button_submit = 'Submit';
        this.management_services_table_modal_submit_header = 'Submit Request';
        this.management_services_table_modal_submit_listheader = 'Select commits to submitted:';
        this.registeredService_serviceId_exists = 'A Service with that Service URL already exists.';
        this.application_title = 'Apereo Central Authentication Service';
        this.application_errors_global = 'Please correct the errors below:';
        this.management_services_status_deleted = 'has been successfully deleted.';
        this.management_services_status_notdeleted = 'A problem has occurred while trying to delete the service. Be aware that the default service can not be deleted.';
        this.management_services_status_listfail = 'Unable to retrieve service listing.';
        this.management_services_status_evaluationOrder_notupdated = 'The service evaluation order can not be updated.';
        this.management_services_status_committed = 'Service changes successfully committed.';
        this.management_services_status_published = 'Service changes successfully published.';
        this.management_services_status_notcommitted = 'A problem has occurred while trying to commit service changes. Please check system logs for additional information.';
        this.management_services_status_notpublished = 'A problem has occurred while trying to publish services to CAS nodes.  Please check system logs for additional information.';
        // EDIT/ADD SERVICE FORM
        this.services_form_instructions = 'Please make sure to commit your changes by clicking on the Save Changes button at the bottom of the page.';
        this.services_form_required = 'Required';
        // GENERAL LABELS
        this.services_form_label_true = 'True';
        this.services_form_label_false = 'False';
        // SPECIFIC LABELS
        this.services_form_label_name = 'Service Name';
        this.services_form_label_description = 'Description';
        this.services_form_label_type = 'Service Type';
        this.services_form_label_casClients = 'CAS Client';
        this.services_form_label_renewalDate = 'Renewal Date';
        this.services_form_label_theme = 'Theme';
        this.services_form_label_serviceId = 'Service URL';
        this.services_form_label_entityId = 'Entity ID';
        this.services_form_label_redirect_url = 'Redirect URL';
        this.services_form_label_consumer_url = 'Consumer URL';
        this.services_form_label_requiredHandlers = 'Required Handlers';
        this.services_form_label_requiresDuo = 'Requires Duo';
        this.services_form_label_evalOrder = 'Evaluation Order';
        this.services_form_label_logoutUrl = 'Logout URL';
        this.services_form_label_informationUrl = 'Information URL';
        this.services_form_label_privacyUrl = 'Privacy URL';
        this.services_form_label_logoUrl = 'Logo URL';
        this.services_form_label_logoutType = 'Logout Type';
        this.services_form_label_assignedId = 'Assigned ID';
        this.services_form_label_uap_default = 'Default';
        this.services_form_label_uap_anon = 'Anonymous';
        this.services_form_label_uap_anonAttribute = 'Username Attribute';
        this.services_form_label_uap_principleAtt = 'Principle Attribute';
        this.services_form_label_uap_saltSetting = 'Salt Setting';
        this.services_form_label_uap_usernameAttribute = 'Username Attribute';
        this.services_form_label_pubKey_location = 'Location';
        this.services_form_label_pubKey_algorithm = 'Algorithm';
        this.services_form_label_proxyPolicy_refuse = 'Refuse';
        this.services_form_label_proxyPolicy_regex = 'Regex';
        this.services_form_label_oauthClientSecret = 'OAuth Client Secret';
        this.services_form_label_oauthClientId = 'OAuth Client ID';
        this.services_form_label_oauthShowSecret = 'Show Client Secret';
        this.services_form_label_oauthBypass = 'OAuth Bypass Approval Prompt';
        this.services_form_label_oauthRefreshToken = 'OAuth Refresh Token Generation';
        this.services_form_label_oauthJsonFormat = 'JSON format for access tokens';
        this.services_form_label_oidcClientSecret = 'OIDC Client Secret';
        this.services_form_label_oidcClientId = 'OIDC Client ID';
        this.services_form_label_oidcShowSecret = 'Show Client Secret';
        this.services_form_label_oidcBypass = 'OIDC Bypass Approval Prompt';
        this.services_form_label_oidcRefreshToken = 'OIDC Refresh Token Generation';
        this.services_form_label_oidcJsonFormat = 'JSON format for access tokens';
        this.services_form_label_attrRelease_excludeDefault = 'Exclude default bundle of attributes for release';
        this.services_form_label_attrRelease_releaseCredPassword = 'Authorized to release to credential password';
        this.services_form_label_attrRelease_releaseProxyTicket = 'Authorized to release proxy granting ticket ID';
        this.services_form_label_attrRelease_attrFilter = 'Attribute Filter Pattern';
        this.services_form_label_attrRelease_attrFilter_excludeUnmapped = 'Exclude Unmapped Attributes';
        this.services_form_label_attrRelease_attrFilter_completeMatch = 'Complete Match';
        this.services_form_label_attrRelease_attrFilter_scripted = 'Script';
        this.services_form_label_attrRelease_principleAttRepo_default = 'Default';
        this.services_form_label_attrRelease_principleAttRepo_cached = 'Cached';
        this.services_form_label_attrRelease_principleAttRepo_cached_timeUnit = 'Time Unit';
        this.services_form_label_attrRelease_principleAttRepo_cached_expiration = 'Expiration';
        this.services_form_label_attrRelease_principleAttRepo_cached_mergeStrategy = 'Merging Strategy';
        this.services_form_label_attrRelease_policies_scriptFile = 'Script File Location';
        this.services_form_label_attrRelease_policies_script = 'Script Engine';
        this.services_form_label_attrRelease_policies_groovy = 'Groovy Script';
        this.services_form_label_attrRelease_policies_denyAll = 'Deny All';
        this.services_form_label_attrRelease_policies_returnAll = 'Return All';
        this.services_form_label_attrRelease_policies_returnAllowed = 'Return Allowed';
        this.services_form_label_attrRelease_policies_returnMapped = 'Return Mapped';
        this.services_form_label_attrRelease_policies_sourceAttribute = 'Source Attribute';
        this.services_form_label_attrRelease_policies_casAttribute = 'CAS Attribute';
        this.services_form_label_attrRelease_policies_wsFedClaim = 'WS Federation Claim';
        this.services_form_label_attrRelease_policies_restful = 'REST Endpoint';
        this.services_form_label_attrRelease_policies_groovySaml = 'Script File Location';
        this.services_form_label_attrRelease_consent_enabled = 'User Consent Enabled';
        this.services_form_label_attrRelease_consent_excludedAttributes = 'Excluded Attributes';
        this.services_form_label_attrRelease_consent_includeOnlyAttributes = 'Include Only Attributes';
        this.services_form_label_attrRelease_releaseAuthenticationAttributes = 'Authorized to release authentication attributes';
        this.services_form_label_attrRelease_entityAttributeValues = 'Metadata Entity Attribute Values';
        this.services_form_label_attrRelease_entityAttribute = 'Metadata Entity Attribute';
        this.services_form_label_attrRelease_entityAttributeFormat = 'Metadata Entity Attribute Format';
        this.services_form_label_sas_authorizedCodes = 'Acceptable HTTP Codes';
        this.services_form_label_sas_casEnabled = 'Enable Service';
        this.services_form_label_sas_ssoEnabled = 'Allow Single Sign-On';
        this.services_form_label_sas_requireAll = 'Require All Attributes';
        this.services_form_label_sas_requiredAttr = 'Required Attributes';
        this.services_form_label_sas_starttime = 'Starting Date/Time';
        this.services_form_label_sas_endtime = 'Ending Date/Time';
        this.services_form_label_sas_unauthorizedredirecturl = 'Unauthorized Redirect Url';
        this.services_form_label_sas_remoteUrl = 'Remote Url';
        this.services_form_label_sas_caseinsensitive = 'Case Insensitive';
        this.services_form_label_sas_rejectedattributes = 'Rejected Attributes';
        this.services_form_label_sas_rejectedattributes_name = '\'Name\'';
        this.services_form_label_sas_rejectedattributes_value = '\'Values\'';
        this.services_form_label_sas_selecttype = 'Select Type';
        this.services_form_label_sas_grouper_groupfield = 'Group Field';
        this.services_form_label_sas_surrogate_enabled = 'Surrogate Enabled';
        this.services_form_label_sas_surrogate_ssoEnabled = 'Surrogate SSO Enabled';
        this.services_form_label_sas_surrogate_requiredAttributes = 'Surrogate Required Attributes';
        this.services_form_label_multiauth_providers = 'Providers';
        this.services_form_label_multiauth_failuremode = 'Failure Mode';
        this.services_form_label_multiauth_principalattribute_nametrigger = 'Principal Attribute Name Trigger';
        this.services_form_label_multiauth_principalattribute_valuetomatch = 'Principal Attribute Value To Match';
        this.services_form_label_multiauth_bypassenabled = 'Enable Bypass';
        this.services_form_label_saml_header = 'SAML Client';
        this.services_form_label_saml_metadata_location = 'Metadata Location';
        this.services_form_label_saml_metadata_maximumvalidity = 'Metadata Maximum Validity';
        this.services_form_label_saml_authenticationcontextclass = 'Authentication Context Class';
        this.services_form_label_saml_metadata_signaturepublickeylocation = 'Metadata Public Key Location';
        this.services_form_label_saml_signassertions = 'Sign Assertions';
        this.services_form_label_saml_signresponses = 'Sign Responses';
        this.services_form_label_saml_encryptassertions = 'Encrypt Assertions';
        this.services_form_label_saml_removeEmptyEntities = 'Remove Empty Entities Descriptors';
        this.services_form_label_saml_removeRoleless = 'Remove Empty Roles';
        this.services_form_label_saml_metadata_pattern = 'Metadata Filter Regex';
        this.services_form_label_saml_metadata_dir = 'Metadata Filter Criteria';
        this.services_form_label_saml_metadata_role = 'Whitelisted Metadata Roles';
        this.services_form_label_saml_requiredNameIdFormat = 'Required NameID Format';
        this.services_form_label_saml_serviceProviderNameQualifier = 'Service Provider Name Qualifier';
        this.services_form_label_saml_nameQualifier = 'Name Qualifier';
        this.services_form_label_saml_skipAssertionNameId = 'Skip generating assertion name id';
        this.services_form_label_saml_skipInResponseTo = 'Skip generating subject confirmation InRespsonseTo';
        this.services_form_label_saml_skipNotOnOrAfter = 'Skip generating subject confirmation NotOnOrAfter';
        this.services_form_label_saml_skipRecipient = 'Skip generating subject confirmation Recipient';
        this.services_form_label_saml_skipNotBefore = 'Skip generating subject confirmation NotBefore';
        this.services_form_label_saml_signingCredentialType = 'Signing Credential Type';
        this.services_form_label_oidc_scopes = 'Scopes';
        this.services_form_label_oidc_dynamic = 'Dynamically Registered';
        this.services_form_label_oidc_dynamicDate = 'Dynam ically Registered At';
        this.services_form_label_oidc_signToken = 'Sign ID Token';
        this.services_form_label_oidc_implicit = 'Enable Implicit';
        this.services_form_label_oidc_encrypt = 'Encrypt ID Token';
        this.services_form_label_oidc_encryptEnc = 'Encryption Encoding Algorithm';
        this.services_form_label_oidc_encryptAlg = 'Encryption Algorithm';
        this.services_form_label_oidc_jwks = 'JSON Web Keystore';
        this.services_form_label_oidc_user_defined_scopes = 'User Defined Scopes';
        this.services_form_label_oidc_subject_type = 'Subject Type';
        this.services_form_label_oidc_sector_identifier_uri = 'Sector Identifier URI';
        this.services_form_label_expirationPolicy_expirationDate = 'Expiration Date';
        this.services_form_label_expirationPolicy_deleteWhenExpired = 'Delete service when expired';
        this.services_form_label_expirationPolicy_notifyWhenDeleted = 'Notifiy contacts when service is deleted';
        this.services_form_header_page_addService = 'Add Service';
        this.services_form_header_page_editService = 'Edit Service';
        this.services_form_header_oauthOptions = 'OAuth Client Options Only';
        this.services_form_header_usernameAttProvider = 'Username Attribute Provider Options';
        this.services_form_header_pubKey = 'Public Key Options';
        this.services_form_header_proxyPolicy = 'Proxy Policy Options';
        this.services_form_header_attrRelPolicy = ' Attribute Release Policy Options';
        this.services_form_header_principleAttRepo = 'Principle Attribute Repository Options';
        this.services_form_header_attrPolicy = 'Attribute Policy Options';
        this.services_form_header_sas = 'Service Access Strategy';
        this.services_form_header_properties = 'Properties';
        this.services_form_header_properties_name = '\'Name\'';
        this.services_form_header_properties_value = '\'Values\'';
        this.services_form_header_multiauth = 'Multifactor Authentication Policy';
        this.services_form_header_samlclient = 'SAML Client';
        this.services_form_button_save = 'Save Changes';
        this.services_form_button_cancel = 'Cancel';
        this.services_form_warning_casDisabled = 'By disabling the service it will no longer be accessible.';
        this.services_form_alert_loadingFailed = 'An error has occurred while attempting to load your service. Please try again later.';
        this.services_form_alert_formHasErrors = 'Form validation has failed. Please fix the errors before attempting to save again.';
        this.services_form_alert_unableToSave = 'An error has occurred while attempting to save the service. Please try again later.';
        this.services_form_alert_serviceAdded = 'Service has been added successfully.';
        this.services_form_alert_serviceUpdated = 'Service has been successfully updated.';
        // SERVICE FORM TOOLTIPS
        this.services_form_tooltip_assignedId = 'Numeric identifier for this service that is auto-generated by CAS.';
        this.services_form_tooltip_serviceId = 'A url that represents the application. This can be a regex/ant formatted url.';
        this.services_form_tooltip_entityId = 'An string that represents the EntityId of the SAML2 SP. This can be a regex pattern.';
        this.services_form_tooltip_redirect_url = 'A url that represents the OAuth/OIDC server to redirect to.';
        this.services_form_tooltip_consumer_url = 'A url that represents a WS Federation Consumer URL';
        this.services_form_tooltip_name = 'The service name.';
        this.services_form_tooltip_description = 'The service description.';
        this.services_form_tooltip_type = 'Everything that applies to a CAS client applies to an OAuth client too, but OAuth clients have a few more extra settings.';
        this.services_form_tooltip_casClients = 'List any known CAS Clients used by this service.(mod_auth_cas...)';
        this.services_form_tooltip_renewalDate = 'This is the date by which the service will need to verified active by the service contacts.';
        this.services_form_tooltip_oauthClientSecret = 'Secret key for this OAuth client. Only applies to OAuth service types.';
        this.services_form_tooltip_oauthClientId = 'OAuth client id for this OAuth client. Only applies to OAuth service types.';
        this.services_form_tooltip_oauthShowSecret = 'Enable to show your OAuth Client Secret.';
        this.services_form_tooltip_oauthBypass = 'Indicates whether the OAuth confirmation screen should be displayed before accessing the service application.';
        this.services_form_tooltip_oauthRefreshToken = 'Indicates whether a refresh token should be generated with the access token for this OAuth client';
        this.services_form_tooltip_oauthJsonFormat = 'Indicates whether the access token response should be in JSON format or in plain text';
        this.services_form_tooltip_oidcClientSecret = 'Secret key for this OIDC client. Only applies to OIDC service types.';
        this.services_form_tooltip_oidcClientId = 'OAuth client id for this OIDC client. Only applies to OIDC service types.';
        this.services_form_tooltip_oidcShowSecret = 'Enable to show your OIDC Client Secret.';
        this.services_form_tooltip_oidcBypass = 'Indicates whether the OIDC confirmation screen should be displayed before accessing the service application.';
        this.services_form_tooltip_oidcRefreshToken = 'Indicates whether a refresh token should be generated with the access token for this OIDC client';
        this.services_form_tooltip_oidcJsonFormat = 'Indicates whether the access token response should be in JSON format or in plain text';
        this.services_form_tooltip_theme = 'A token that represents the theme that should be applied to CAS when this service asks for authentication.  Valid values are a theme name configured in the CAS deployment, a REST endpoint or a groovy file location.';
        this.services_form_tooltip_evalOrder = 'Determines how CAS should load, sort and evaluate services per this numeric order.';
        this.services_form_tooltip_requiredHandlers = 'Collection of authentication handler ids defined in the CAS server configuration ' +
            'that indicate the set of authentication handlers that must successfully execute before access to this service can be granted.';
        this.services_form_tooltip_requiresDuo = 'Setting to true will require Duo authentication for this service.';
        this.services_form_tooltip_logoutUrl = 'Url where logout requests will be sent to, for this service.';
        this.services_form_tooltip_informationUrl = 'Url that describes help information and guides for this service.';
        this.services_form_tooltip_privacyUrl = 'Url that describes the privacy policies for this service.';
        this.services_form_tooltip_logoUrl = 'The logo representing this service that would be displayed on the login page. Could be a file/classpath path or an actual http url.';
        this.services_form_tooltip_logoutType = 'Defines how CAS should execute logout operations when dealing with this service.';
        this.services_form_tooltip_uap_anonAttribute = 'Username attribute used for anonymous id generation.';
        this.services_form_tooltip_uap_saltSetting = 'The salt used for anonymous id generation.';
        this.services_form_tooltip_uap_usernameAttribute = 'Username attribute used to return back to the service as the identifier.';
        this.services_form_tooltip_pubKey_location = 'The location to the public key file used to authenticate and sign the CAS response. ' +
            'This is specifically used to encrypt and sign the credential and the proxy granting ticket returned directly in the CAS validation ' +
            'response, provided the service is authorized to release those attributes.';
        this.services_form_tooltip_pubKey_algorithm = 'Represents a public key for a CAS registered service, used to encrypt credentials, proxy granting ticket ids for release.';
        this.services_form_tooltip_proxyPolicy_regex = 'Matches the proxy callback url against a regex pattern. A successful match will authorize proxy authentication. ';
        this.services_form_tooltip_attrRelease_excludeDefault = 'Indicates whether global and default attributes set to release to all applications ' +
            'should be excluded for release for this specific application.';
        this.services_form_tooltip_attrRelease_attrFilter = 'A regex pattern used to filter attributes based on their values only. ' +
            'Values that successfully pass the filter will be available for release to the application.';
        this.services_form_tooltip_attrRelease_attrFilter_excludeUnmapped = 'Indicates whether unmapped attributes should be removed from the final bundle.';
        this.services_form_tooltip_attrRelease_attrFilter_completeMatch = 'Indicates whether pattern-matching should execute over the entire value region';
        this.services_form_tooltip_attrRelease_attrFilter_scripted = 'This field can accept either an inline groovy script that will be executed or a location of an external script file that will be loaded and executed.';
        this.services_form_tooltip_attrRelease_releaseCredPassword = 'Release credential password to the application?';
        this.services_form_tooltip_attrRelease_releaseProxyTicket = 'Release proxy-granting ticket id to the application?';
        this.services_form_tooltip_attrRelease_principleAttRepo_cached_timeUnit = 'Time unit of measure for the cache expiration policy.';
        this.services_form_tooltip_attrRelease_principleAttRepo_cached_expiration = 'The cache expiration time. ';
        this.services_form_tooltip_attrRelease_policies_returnAllowed = 'List of resolved attributes out of the available collection of attributes from the attribute repository. Select attributes that are allowed to be released to the application';
        this.services_form_tooltip_attrRelease_policies_returnWsMapped = 'List of WS Federation Claims that will be mapped to the corresponding attribute from the attributes repository.';
        this.services_form_tooltip_attrRelease_policies_restful = 'The URL of the REST endpoint that will be called to retrieve a list of attributes that will be released';
        this.services_form_tooltip_attrRelease_policies_groovySaml = 'Location of a groovy script file that can be triggered by the server to determine the attributes to be released';
        this.services_form_tooltip_attrRelease_consent_enabled = 'Control whether consent is active/inactive for this service.';
        this.services_form_tooltip_attrRelease_consent_excludedAttributes = 'Exclude the indicated attributes from consent.';
        this.services_form_tooltip_attrRelease_consent_includeOnlyAttributes = 'Force-include the indicated attributes in consent, provided attributes are resolved.';
        this.services_form_tooltip_attrRelease_releaseAuthenticationAttributes = 'Determines whether this policy should exclude the authentication/protocol attributes for release. Authentication attributes are considered those that are not tied to a specific principal and define extra supplamentary metadata about the authentication event itself, such as the commencement date.';
        this.services_form_tooltip_attrRelease_entityAttributeValues = 'List of attributes that are defined as part of the SP Metadata';
        this.services_form_tooltip_attrRelease_entityAttribute = 'The EntityId for the SP providing the metadata attributes';
        this.services_form_tooltip_attrRelease_entityAttributeFormat = 'Format description for the entity attribute.  This field is optional';
        this.services_form_tooltip_sas_starttime = 'Determines the starting date/time from which service access is allowed.';
        this.services_form_tooltip_sas_endtime = 'Determines the ending date/time from which service access is allowed.';
        this.services_form_tooltip_sas_casEnabled = 'Decides whether access to this service is authorized by CAS.';
        this.services_form_tooltip_sas_ssoEnabled = 'Decides whether this service is allowed to participate in SSO.';
        this.services_form_tooltip_sas_requireAll = 'Decides whether all attributes AND corresponding values should be evaluated before access can be granted. If left unchecked, the first successful match on attribute name and value will allow access.';
        this.services_form_tooltip_sas_requiredAttr = 'These are a set of attributes along with their values that decide whether access to this service can be granted. To configure, only provide values for attributes you care about, and leave the rest blank.';
        this.services_form_tooltip_sas_unauthorizedredirecturl = 'URL to which CAS should direct in the event that service access is defined.';
        this.services_form_tooltip_sas_remoteUrl = 'URL that CAS should contact to determine if access to this service should be granted.';
        this.services_form_tooltip_sas_caseinsensitive = 'Indicates whether matching on required attribute values should be done in a case-insensitive manner.';
        this.services_form_tooltip_sas_rejectedattributes = 'A Map of rejected principal attribute names along with the set of values for each attribute. These attributes MUST NOT be available to the authenticated Principal so that access may be granted. If none is defined, the check is entirely ignored.';
        this.services_form_tooltip_sas_selecttype = 'Access strategy type';
        this.services_form_tooltip_sas_authorizedCodes = 'Acceptable HTTP codes before granting access to this service.';
        this.services_form_tooltip_sas_grouper = 'This access strategy attempts to locate Grouper groups for the CAS principal. The groups returned by ' +
            'Grouper are collected as CAS attributes and examined against the list of required attributes for service access.';
        this.services_form_tooltip_sas_surrogate_enabled = 'Determines whether this service is allowed to use surrogate authentication.';
        this.services_form_tooltip_sas_surrogate_ssoEnabled = 'Determines whether a Surrogate authentication should participate in SSO';
        this.services_form_tooltip_sas_surrogate_requiredAttributes = 'List of attributes and values that must be present for the primary user in order to allow surrogate authentication';
        this.services_form_tooltip_multiauth_providers = 'List of multifactor provider ids to assign to this service.';
        this.services_form_tooltip_multiauth_failuremode = 'Decide what CAS should do in the event that a provider is not available.';
        this.services_form_tooltip_multiauth_principalattribute_nametrigger = 'Principal attribute name to trigger MFA when accessing this service.';
        this.services_form_tooltip_multiauth_principalattribute_valuetomatch = 'Principal attribute value to match in order to trigger MFA when accessing this service.';
        this.services_form_tooltip_multiauth_bypassenabled = 'Bypass multifactor authentication for this service.';
        this.services_form_tooltip_saml_header = 'SAML Client';
        this.services_form_tooltip_saml_metadata_location = 'Metadata location for this particular service provider.';
        this.services_form_tooltip_saml_metadata_maximumvalidity = 'Indicates how long should metadata be considered valid.';
        this.services_form_tooltip_saml_authenticationcontextclass = 'The authentication context class that may be passed to the service provider. If ' +
            'none is defined here forcefully, metadata will be consulted instead.';
        this.services_form_tooltip_saml_metadata_signaturepublickeylocation = 'Location of the metadata signing public key so its authenticity can be ' +
            'verified.';
        this.services_form_tooltip_saml_signassertions = 'Sign Assertions';
        this.services_form_tooltip_saml_signresponses = 'Sign Responses';
        this.services_form_tooltip_saml_encryptassertions = 'Encrypt Assertions';
        this.services_form_tooltip_saml_removeEmptyEntities = 'Controls whether to keep entities descriptors that contain no entity descriptors';
        this.services_form_tooltip_saml_removeRoleless = 'Controls whether to keep entity descriptors that contain no roles';
        this.services_form_tooltip_saml_metadata_pattern = 'Regex applied to entity ids in a metadata aggregate';
        this.services_form_tooltip_saml_metadata_dir = 'Whether to include/exclude entity ids that match the filter pattern';
        this.services_form_tooltip_saml_metadata_role = 'Whitelisted roles to keep in the metadata.';
        this.services_form_tooltip_saml_requiredNameIdFormat = 'Force the indicated Name ID format in the final SAML response';
        this.services_form_tooltip_saml_serviceProviderNameQualifier = 'Overwrite the SPNameQualifier attribute of the produced subject name id';
        this.services_form_tooltip_saml_nameQualifier = 'Overwrite the NameQualifier attribute of the produced subject name id';
        this.services_form_tooltip_saml_skipAssertioNameId = 'Whether generation of a name identifier should be skipped for assertions';
        this.services_form_tooltip_saml_skipInResponseTo = 'Whether generation of the InResponseTo element should be skipped for subject confirmations';
        this.services_form_tooltip_saml_skipNotOnOrAfter = 'Whether generation of the NotOnOrAfter element should be skipped for subject confirmations';
        this.services_form_tooltip_saml_skipRecipient = 'Whether generation of the Recipient element should be skipped for subject confirmations';
        this.services_form_tooltip_saml_skipNotBefore = 'Whether generation of the NotBefore element should be skipped for subject confirmations';
        this.services_form_tooltip_saml_signingCredentialType = 'This setting controls the type of the signature block produced in the final SAML response for this application. The latter, being the default, encodes the signature in PEM format inside a X509Data block while the former encodes the signature based on the resolved public key under a DEREncodedKeyValue block.';
        this.services_form_tooltip_oidc_signToken = 'Whether ID tokens should be signed.';
        this.services_form_tooltip_oidc_encrypt = 'Whether ID tokens should be encrypted.';
        this.services_form_tooltip_oidc_encryptEnc = 'Encryption content encoding algorithm to use with ID tokens.';
        this.services_form_tooltip_oidc_encryptAlg = 'Encryption algorithm to use with ID tokens.';
        this.services_form_tooltip_oidc_implicit = 'Indicates whether this service should support the implicit flow.';
        this.services_form_tooltip_oidc_jwks = 'Location of the JSON web keystore to sign id tokens with. ';
        this.services_form_tooltip_oidc_scopes = 'Scopes';
        this.services_form_tooltip_oidc_user_defined_scopes = 'List any custom defined scopes that should be released.';
        this.services_form_tooltip_oidc_subject_type = 'Type to use when generating principal identifiers. Default is public.';
        this.services_form_tooltip_oidc_sector_identifier_uri = 'Host value of this URL is used as the sector identifier for the pairwise identifier calculation. If left undefined, the host value of the serviceId will be used instead.';
        this.services_form_tooltip_expirationPolicy_expirationDate = 'The date on which the registration record is deemed expired. The expiration date may be specified in 2011-12-03T10:15:30, 09/24/1980 04:30 PM, 09/24/2014 6:30 AM, 09/24/2013 18:45, 09/24/2017 or 2017-10-25 formats.';
        this.services_form_tooltip_expirationPolicy_deleteWhenExpired = 'When true, removes the application from the CAS service registry if and when expired. Otherwise the application record will be marked as disabled.';
        this.services_form_tooltip_expirationPolicy_notifyWhenDeleted = 'Notifies contacts of the application via email or text, assuming valid contacts with email addresses or phone numbers are defined and CAS is configured to send email messages or SMS notifications. The notification is only sent if the application is expired and is about to be deleted from the registry.';
        this.services_form_tooltip_attrRelease_principleAttRepo_cached_mergeStrategy = 'Decides how attributes that are retrieved from the cache ' +
            'should be merged into the existing attribute repository. Attributes may be replaced, ignored or contain multiple ' +
            'values as a result of the merge action.';
        this.management_services_service_noAction = 'No further action is required.';
        this.screen_unavailable_heading = 'The CAS management webapp is unavailable. ';
        this.screen_unavailable_message = 'There was an error trying to complete your request. Please notify your support desk or try again.';
        this.footer_links = 'Links to CAS Resources:';
        this.footer_homePage = 'Home Page';
        this.footer_wiki = 'Wiki';
        this.footer_issueTracker = 'Issue Tracker';
        this.footer_mailingLists = 'Mailing Lists';
        this.footer_copyright = 'Copyright &copy; 2005 - 2017 Apereo, Inc. All rights reserved.';
        this.footer_poweredBy = 'Powered by <a href=\'http://www.apereo.org/cas\'>Apereo Central Authentication Service {0}</a>';
        this.services_form_label_canonicalizationMode = 'cononicalizationMode';
        this.services_form_label_attrRelease_policies_patternMatching = 'Pattern Matching';
        this.services_form_label_attrRelease_policies_releaseIncommon = 'InCommon';
        this.services_form_label_wsfed_realm = 'Realm';
        this.services_form_label_wsfed_appliesTo = 'appliesTo';
        this.services_form_label_wsfed_wsFederationOnly = 'WS Federation only';
        this.services_form_header_wsfedOptions = 'WS Federation';
        this.services_form_header_nameId = 'Name ID Selection';
        this.services_form_header_nameId_name = 'Name';
        this.services_form_header_nameId_value = 'Value';
        this.services_form_tooltip_uap_canonicalizationMode = 'canonicalizationMode tooltip';
        this.services_form_tooltip_attrRelease_policies_patternMatching = 'In the event that an aggregate is defined containing multiple entity ids, the below attribute release policy may be used to release a collection of allowed attributes to entity ids grouped together by a regular expression pattern.';
        this.services_form_tooltip_attrRelease_policies_releaseInCommon = 'Release the attribute bundles needed for InCommon\'s Research and Scholarship service providers?';
        this.services_form_tooltip_wsfed_realm = 'The realm identifier of the application, identified via the wtrealm parameter. This needs to match the realm defined for the identity provider. By default it’s set to the realm defined for the CAS identity provider.';
        this.services_form_tooltip_wsfed_appliesTo = 'Controls to whom security tokens apply. Defaults to the realm';
        this.services_form_label_uap_canonicalizationMode = 'Canonicalization Mode';
    }
    Messages = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])()
    ], Messages);
    return Messages;
}());



/***/ }),

/***/ "../../../../../src/app/search/SearchService.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SearchService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service__ = __webpack_require__("../../../../../src/app/service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SearchService = (function (_super) {
    __extends(SearchService, _super);
    function SearchService(http) {
        return _super.call(this, http) || this;
    }
    SearchService.prototype.search = function (query) {
        return this.get('search?query=' + query);
    };
    SearchService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], SearchService);
    return SearchService;
}(__WEBPACK_IMPORTED_MODULE_1__service__["a" /* Service */]));



/***/ }),

/***/ "../../../../../src/app/search/search.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/search/search.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"display:flex;margin-bottom:10px;\">\n  <div style=\"margin-left:25px;padding-top: 10px;\">\n    <mat-icon style=\"padding-top: 3px;\">search</mat-icon>\n    <h4 style=\"display: inline;position: relative;top: -5px;\">\n      <ng-container i18n>\n        Search Results\n      </ng-container>\n    </h4>\n  </div>\n  <div style=\"flex: 1 1 auto\"></div>\n  <div>\n    <app-controls></app-controls>\n  </div>\n</div>\n\n<div style=\"display: flex; flex-direction: column; margin-right:25px;margin-left:25px;\">\n  <mat-table #table [dataSource]=\"dataSource\">\n\n    <ng-container matColumnDef=\"name\">\n      <mat-header-cell *matHeaderCellDef>\n        <ng-container i18n>\n          Name\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\">\n        <a (click)=\"serviceEdit(row.assignedId)\">\n          {{ row.name }}\n        </a>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container matColumnDef=\"serviceId\">\n      <mat-header-cell *matHeaderCellDef>\n        <ng-container i18n>\n          Service Url\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\">\n        {{ row.serviceId }}\n      </mat-cell>\n    </ng-container>\n\n    <ng-container matColumnDef=\"description\">\n      <mat-header-cell *matHeaderCellDef>\n        <ng-container i18n>\n          Description\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\">\n        {{ row.description }}\n      </mat-cell>\n    </ng-container>\n\n\n    <mat-header-row *matHeaderRowDef=\"displayedColumns\"></mat-header-row>\n    <mat-row *matRowDef=\"let row; columns: displayedColumns;\"></mat-row>\n  </mat-table>\n\n  <mat-paginator #paginator\n                [pageSize]=\"10\"\n                [pageSizeOptions]=\"[5, 10, 25, 100]\">\n  </mat-paginator>\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/search/search.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SearchComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__SearchService__ = __webpack_require__("../../../../../src/app/search/SearchService.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var SearchComponent = (function () {
    function SearchComponent(messages, router, route, location, service, snackBar) {
        this.messages = messages;
        this.router = router;
        this.route = route;
        this.location = location;
        this.service = service;
        this.snackBar = snackBar;
        this.displayedColumns = ['name', 'serviceId', 'description'];
    }
    SearchComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_1__angular_material__["y" /* MatTableDataSource */]([]);
        this.dataSource.paginator = this.paginator;
        this.route.paramMap
            .switchMap(function (params) { return _this.service.search(params.get('query')); })
            .subscribe(function (resp) { return _this.dataSource.data = resp; });
    };
    SearchComponent.prototype.serviceEdit = function (id) {
        this.router.navigate(['form', id]);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])(__WEBPACK_IMPORTED_MODULE_1__angular_material__["q" /* MatPaginator */]),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1__angular_material__["q" /* MatPaginator */])
    ], SearchComponent.prototype, "paginator", void 0);
    SearchComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-search',
            template: __webpack_require__("../../../../../src/app/search/search.component.html"),
            styles: [__webpack_require__("../../../../../src/app/search/search.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_3__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_4__angular_common__["f" /* Location */],
            __WEBPACK_IMPORTED_MODULE_5__SearchService__["a" /* SearchService */],
            __WEBPACK_IMPORTED_MODULE_1__angular_material__["v" /* MatSnackBar */]])
    ], SearchComponent);
    return SearchComponent;
}());



/***/ }),

/***/ "../../../../../src/app/service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Service; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/**
 * Created by tsschmi on 4/25/17.
 */

var Service = (function () {
    function Service(http) {
        this.http = http;
    }
    Service.prototype.headers = function () {
        return new __WEBPACK_IMPORTED_MODULE_0__angular_http__["a" /* Headers */]({
            'Content-Type': 'application/json'
        });
    };
    Service.prototype.post = function (url, data) {
        return this.http.post(url, JSON.stringify(data))
            .toPromise()
            .then(function (resp) { return resp; })
            .catch(this.handleError);
    };
    Service.prototype.get = function (url) {
        return this.http.get(url)
            .toPromise()
            .then(function (resp) { return resp; })
            .catch(this.handleError);
    };
    Service.prototype.getText = function (url) {
        return this.http.get(url, { responseType: 'text' })
            .toPromise()
            .then(function (resp) { return resp; })
            .catch(this.handleError);
    };
    Service.prototype.handleError = function (e) {
        console.log('An error Occurred: ' + e);
        return Promise.reject(e.message || e);
    };
    return Service;
}());



/***/ }),

/***/ "../../../../../src/app/services/service.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServiceViewService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service__ = __webpack_require__("../../../../../src/app/service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
/**
 * Created by tschmidt on 2/13/17.
 */



var ServiceViewService = (function (_super) {
    __extends(ServiceViewService, _super);
    function ServiceViewService(http) {
        return _super.call(this, http) || this;
    }
    ServiceViewService.prototype.getServices = function (domain) {
        return this.get('getServices?domain=' + domain);
    };
    ServiceViewService.prototype.delete = function (id) {
        return this.get('deleteRegisteredService?id=' + id);
    };
    ServiceViewService.prototype.updateOrder = function (a, b) {
        return this.post('updateOrder', [a, b]);
    };
    ServiceViewService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], ServiceViewService);
    return ServiceViewService;
}(__WEBPACK_IMPORTED_MODULE_1__service__["a" /* Service */]));



/***/ }),

/***/ "../../../../../src/app/services/services.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".serviceName {\n  display:inline-block;\n  position:relative;\n}\n\n.middle {\n  bottom:5px;\n}\n\n.first {\n\n}\n\n.last {\n\n}\n\n.MODIFY {\n  color: blue;\n  font-style: italic;\n}\n\n.ADD {\n  color:green;\n  font-style: italic;\n}\n\n.DELETE {\n  color:red;\n  font-style: italic;\n}\n\n.descriptionWidth {\n  -webkit-box-flex: 1;\n      -ms-flex: 1 1 auto;\n          flex: 1 1 auto;\n  color: inherit;\n}\n\n.serviceIdWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n  color: inherit;\n}\n\n.nameWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 240px;\n          flex: 0 0 240px;\n  color:inherit !important;\n}\n\n.nameWidth a {\n  color:inherit;\n}\n\n.actionWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 50px;\n          flex: 0 0 50px;\n}\n\n.statusWidth {\n  -webkit-box-flex: 0;\n      -ms-flex: 0 0 50px;\n          flex: 0 0 50px;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/services/services.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"display:flex;margin-bottom:10px;\">\n  <div style=\"margin-left:25px;padding-top: 3px;\">\n    <mat-icon style=\"padding-top: 3px;\">build</mat-icon>\n    <h4 style=\"display: inline;position: relative;top: -5px;\">\n      <ng-container i18n>\n        Manage Services - {{ domain }}\n      </ng-container>\n    </h4>\n  </div>\n  <div style=\"flex: 1 1 auto\">\n  </div>\n  <div>\n    <app-controls></app-controls>\n  </div>\n</div>\n\n<div style=\"display: flex; flex-direction: column;margin-right:25px;margin-left:25px;\">\n  <mat-table #table [dataSource]=\"dataSource\">\n\n    <ng-container matColumnDef=\"actions\">\n      <mat-header-cell *matHeaderCellDef [ngClass]=\"'actionWidth'\">\n        <ng-container i18n>\n          &nbsp;\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\" [ngClass]=\"'actionWidth'\">\n        <button mat-icon-button [matMenuTriggerFor]=\"serviceMenu\" (click)=\"selectedItem = row\">\n          <mat-icon>menu</mat-icon>\n        </button>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container matColumnDef=\"name\">\n      <mat-header-cell *matHeaderCellDef [ngClass]=\"'nameWidth'\">\n        <ng-container i18n>\n          Name\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\" [ngClass]=\"'nameWidth'\">\n        <a (click)=\"serviceEdit(row)\">\n          {{ row.name }}\n        </a>\n      </mat-cell>\n    </ng-container>\n\n    <ng-container matColumnDef=\"serviceId\">\n      <mat-header-cell *matHeaderCellDef [ngClass]=\"'serviceIdWidth'\">\n        <ng-container i18n>\n          Service Url\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\" [ngClass]=\"'serviceIdWidth'\">\n        {{ row.serviceId }}\n      </mat-cell>\n    </ng-container>\n\n    <ng-container matColumnDef=\"description\">\n      <mat-header-cell *matHeaderCellDef [ngClass]=\"'descriptionWidth'\">\n        <ng-container i18n>\n          Description\n        </ng-container>\n      </mat-header-cell>\n      <mat-cell *matCellDef=\"let row\" [ngClass]=\"'descriptionWidth'\">\n        {{ row.description }}\n      </mat-cell>\n    </ng-container>\n\n\n    <mat-header-row *matHeaderRowDef=\"displayedColumns\"></mat-header-row>\n    <mat-row *matRowDef=\"let row; columns: displayedColumns;\" [ngClass]=\"row.status\"></mat-row>\n  </mat-table>\n\n  <mat-paginator #paginator\n                 [pageSize]=\"10\"\n                 [pageSizeOptions]=\"[5, 10, 25, 100]\">\n  </mat-paginator>\n</div>\n\n<mat-menu #serviceMenu>\n  <button mat-menu-item (click)=\"serviceEdit()\">\n    <mat-icon>edit</mat-icon>\n    <ng-container i18n=\"management.services.table.button.edit\">\n      {{ messages.management_services_table_button_edit }}\n    </ng-container>\n  </button>\n  <button mat-menu-item (click)=\"serviceDuplicate()\">\n    <mat-icon>content_copy</mat-icon>\n    <ng-container i18n=\"management.services.table.button.duplicate\">\n      {{ messages.management_services_table_button_duplicate }}\n    </ng-container>\n  </button>\n  <button mat-menu-item (click)=\"openModalDelete()\">\n    <mat-icon>delete</mat-icon>\n    <ng-container i18n=\"management.services.table.button.delete\">\n      {{ messages.management_services_table_button_delete }}\n    </ng-container>\n  </button>\n  <button mat-menu-item (click)=\"moveUp(selectedItem)\" *ngIf=\"showMoveUp()\">\n    <mat-icon>arrow_upward</mat-icon>\n    <ng-container>Move Up</ng-container>\n  </button>\n  <button mat-menu-item (click)=\"moveDown(selectedItem)\" *ngIf=\"showMoveDown()\">\n    <mat-icon>arrow_downward</mat-icon>\n    <ng-container>Move Down</ng-container>\n  </button>\n</mat-menu>\n"

/***/ }),

/***/ "../../../../../src/app/services/services.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServicesComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__messages__ = __webpack_require__("../../../../../src/app/messages.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__service_service__ = __webpack_require__("../../../../../src/app/services/service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__delete_delete_component__ = __webpack_require__("../../../../../src/app/delete/delete.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__controls_controls_service__ = __webpack_require__("../../../../../src/app/controls/controls.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var ServicesComponent = (function () {
    function ServicesComponent(messages, route, router, service, location, dialog, snackBar, controlsService) {
        this.messages = messages;
        this.route = route;
        this.router = router;
        this.service = service;
        this.location = location;
        this.dialog = dialog;
        this.snackBar = snackBar;
        this.controlsService = controlsService;
        this.displayedColumns = ['actions', 'name', 'serviceId', 'description'];
    }
    ServicesComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dataSource = new __WEBPACK_IMPORTED_MODULE_5__angular_material__["y" /* MatTableDataSource */]([]);
        this.dataSource.paginator = this.paginator;
        this.route.data
            .subscribe(function (data) {
            if (!data.resp) {
                _this.snackBar.open(_this.messages.management_services_status_listfail, 'dismiss', {
                    duration: 5000
                });
            }
            setTimeout(function () {
                _this.dataSource.data = data.resp;
            }, 10);
        });
        this.route.params.subscribe(function (params) { return _this.domain = params['domain']; });
    };
    ServicesComponent.prototype.ngAfterViewInit = function () {
    };
    ServicesComponent.prototype.serviceEdit = function (item) {
        if (item) {
            this.selectedItem = item;
        }
        this.router.navigate(['/form', this.selectedItem.assignedId]);
    };
    ServicesComponent.prototype.serviceDuplicate = function () {
        this.router.navigate(['/duplicate', this.selectedItem.assignedId]);
    };
    ServicesComponent.prototype.openModalDelete = function () {
        var _this = this;
        var dialogRef = this.dialog.open(__WEBPACK_IMPORTED_MODULE_6__delete_delete_component__["a" /* DeleteComponent */], {
            data: this.selectedItem,
            width: '500px',
            position: { top: '100px' }
        });
        dialogRef.afterClosed().subscribe(function (result) {
            if (result) {
                _this.delete();
            }
        });
        this.deleteItem = this.selectedItem;
    };
    ;
    ServicesComponent.prototype.delete = function () {
        var _this = this;
        var myData = { id: this.deleteItem.assignedId };
        this.service.delete(Number.parseInt(this.deleteItem.assignedId))
            .then(function (resp) { return _this.handleDelete(resp); })
            .catch(function (e) { return _this.snackBar.open(e.message || e.text(), 'Dismiss', {
            duration: 5000
        }); });
    };
    ;
    ServicesComponent.prototype.handleDelete = function (name) {
        this.snackBar.open(name + ' ' + this.messages.management_services_status_deleted, 'Dismiss', {
            duration: 5000
        });
        this.refresh();
    };
    ServicesComponent.prototype.refresh = function () {
        this.getServices();
    };
    ServicesComponent.prototype.getServices = function () {
        var _this = this;
        this.service.getServices(this.domain)
            .then(function (resp) { return _this.dataSource.data = resp; })
            .catch(function (e) { return _this.snackBar.open(_this.messages.management_services_status_listfail, 'Dismiss', {
            duration: 5000
        }); });
    };
    ServicesComponent.prototype.moveUp = function (a) {
        var _this = this;
        var index = this.dataSource.data.indexOf(a);
        if (index > 0) {
            var b = this.dataSource.data[index - 1];
            a.evalOrder = index - 1;
            b.evalOrder = index;
            this.service.updateOrder(a, b).then(function (resp) { return _this.refresh(); });
        }
    };
    ServicesComponent.prototype.moveDown = function (a) {
        var _this = this;
        var index = this.dataSource.data.indexOf(a);
        if (index < this.dataSource.data.length - 1) {
            var b = this.dataSource.data[index + 1];
            a.evalOrder = index + 1;
            b.evalOrder = index;
            this.service.updateOrder(a, b).then(function (resp) { return _this.refresh(); });
        }
    };
    ServicesComponent.prototype.showMoveUp = function () {
        if (!this.selectedItem) {
            return false;
        }
        var index = this.dataSource.data.indexOf(this.selectedItem);
        return index > 0;
    };
    ServicesComponent.prototype.showMoveDown = function () {
        if (!this.selectedItem) {
            return false;
        }
        var index = this.dataSource.data.indexOf(this.selectedItem);
        return index < this.dataSource.data.length - 1;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])('paginator'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_5__angular_material__["q" /* MatPaginator */])
    ], ServicesComponent.prototype, "paginator", void 0);
    ServicesComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-services',
            template: __webpack_require__("../../../../../src/app/services/services.component.html"),
            styles: [__webpack_require__("../../../../../src/app/services/services.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__messages__["a" /* Messages */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__service_service__["a" /* ServiceViewService */],
            __WEBPACK_IMPORTED_MODULE_4__angular_common__["f" /* Location */],
            __WEBPACK_IMPORTED_MODULE_5__angular_material__["h" /* MatDialog */],
            __WEBPACK_IMPORTED_MODULE_5__angular_material__["v" /* MatSnackBar */],
            __WEBPACK_IMPORTED_MODULE_7__controls_controls_service__["a" /* ControlsService */]])
    ], ServicesComponent);
    return ServicesComponent;
}());



/***/ }),

/***/ "../../../../../src/app/services/services.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServicesModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_component__ = __webpack_require__("../../../../../src/app/services/services.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__services_resolover__ = __webpack_require__("../../../../../src/app/services/services.resolover.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__service_service__ = __webpack_require__("../../../../../src/app/services/service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by tschmidt on 2/23/17.
 */








var ServicesModule = (function () {
    function ServicesModule() {
    }
    ServicesModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_common__["b" /* CommonModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_http__["b" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_7__shared_shared_module__["a" /* SharedModule */]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__services_component__["a" /* ServicesComponent */],
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_5__services_resolover__["a" /* ServicesResolve */],
                __WEBPACK_IMPORTED_MODULE_6__service_service__["a" /* ServiceViewService */]
            ]
        })
    ], ServicesModule);
    return ServicesModule;
}());



/***/ }),

/***/ "../../../../../src/app/services/services.resolover.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ServicesResolve; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__service_service__ = __webpack_require__("../../../../../src/app/services/service.service.ts");
/**
 * Created by tschmidt on 2/13/17.
 */
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ServicesResolve = (function () {
    function ServicesResolve(service, router) {
        this.service = service;
        this.router = router;
    }
    ServicesResolve.prototype.resolve = function (route) {
        var param = route.params['domain'];
        if (!param) {
            return new Promise(function (resolve, reject) { return resolve([]); });
        }
        else {
            return this.service.getServices(param).then(function (resp) { return resp ? resp : null; });
        }
    };
    ServicesResolve = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__service_service__["a" /* ServiceViewService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], ServicesResolve);
    return ServicesResolve;
}());



/***/ }),

/***/ "../../../../../src/app/shared/shared.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SharedModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_hammerjs__ = __webpack_require__("../../../../hammerjs/hammer.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_hammerjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_hammerjs__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_cdk_table__ = __webpack_require__("../../../cdk/esm5/table.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__controls_controls_component__ = __webpack_require__("../../../../../src/app/controls/controls.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__controls_controls_service__ = __webpack_require__("../../../../../src/app/controls/controls.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by tsschmi on 2/28/17.
 */








var SharedModule = (function () {
    function SharedModule() {
    }
    SharedModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_common__["b" /* CommonModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["A" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["e" /* MatCheckboxModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["m" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["l" /* MatIconModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["B" /* MatTooltipModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["u" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["g" /* MatDatepickerModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["p" /* MatNativeDateModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["i" /* MatDialogModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["z" /* MatTableModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_cdk_table__["m" /* CdkTableModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["c" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["s" /* MatRadioModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["t" /* MatRippleModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["d" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["k" /* MatExpansionModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["n" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["o" /* MatMenuModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["f" /* MatChipsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["i" /* MatDialogModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["b" /* MatAutocompleteModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["w" /* MatSnackBarModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["r" /* MatPaginatorModule */]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_6__controls_controls_component__["a" /* ControlsComponent */]
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_7__controls_controls_service__["a" /* ControlsService */]
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["A" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["e" /* MatCheckboxModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["m" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["l" /* MatIconModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["B" /* MatTooltipModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["u" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["g" /* MatDatepickerModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["p" /* MatNativeDateModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["i" /* MatDialogModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["z" /* MatTableModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_cdk_table__["m" /* CdkTableModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["c" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["s" /* MatRadioModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["t" /* MatRippleModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["d" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["k" /* MatExpansionModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["n" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["o" /* MatMenuModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["f" /* MatChipsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["i" /* MatDialogModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["b" /* MatAutocompleteModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["w" /* MatSnackBarModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material__["r" /* MatPaginatorModule */],
                __WEBPACK_IMPORTED_MODULE_6__controls_controls_component__["a" /* ControlsComponent */]
            ]
        })
    ], SharedModule);
    return SharedModule;
}());



/***/ }),

/***/ "../../../../../src/app/util/util.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Util; });
var Util = (function () {
    function Util() {
    }
    Util.isEmpty = function (obj) {
        return !obj || Object.keys(obj).length === 0;
    };
    return Util;
}());



/***/ }),

/***/ "../../../../../src/domain/access-strategy.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceAccessStrategy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultRegisteredServiceAccessStrategy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return RemoteEndpointServiceAccessStrategy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "e", function() { return TimeBasedRegisteredServiceAccessStrategy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return GrouperRegisteredServiceAccessStrategy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return SurrogateRegisteredServiceAccessStrategy; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceAccessStrategy = (function () {
    function RegisteredServiceAccessStrategy(strat) {
        this.enabled = true;
        this.ssoEnabled = false;
        this.requireAllAttributes = false;
        this.enabled = (strat && strat.enabled) || true;
        this.ssoEnabled = strat && strat.ssoEnabled;
        this.unauthorizedRedirectUrl = strat && strat.unauthorizedRedirectUrl;
        this.requiredAttributes = strat && strat.requiredAttributes;
        this.requireAllAttributes = strat && strat.requireAllAttributes;
        this.rejectedAttributes = strat && strat.rejectedAttributes;
        this.caseInsensitive = strat && strat.caseInsensitive;
    }
    return RegisteredServiceAccessStrategy;
}());

var DefaultRegisteredServiceAccessStrategy = (function (_super) {
    __extends(DefaultRegisteredServiceAccessStrategy, _super);
    function DefaultRegisteredServiceAccessStrategy(strat) {
        var _this = _super.call(this, strat) || this;
        _this['@class'] = DefaultRegisteredServiceAccessStrategy.cName;
        return _this;
    }
    DefaultRegisteredServiceAccessStrategy.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceAccessStrategy.cName;
    };
    DefaultRegisteredServiceAccessStrategy.cName = 'org.apereo.cas.services.DefaultRegisteredServiceAccessStrategy';
    return DefaultRegisteredServiceAccessStrategy;
}(RegisteredServiceAccessStrategy));

var RemoteEndpointServiceAccessStrategy = (function (_super) {
    __extends(RemoteEndpointServiceAccessStrategy, _super);
    function RemoteEndpointServiceAccessStrategy(strat) {
        var _this = _super.call(this, strat) || this;
        _this['@class'] = RemoteEndpointServiceAccessStrategy.cName;
        return _this;
    }
    RemoteEndpointServiceAccessStrategy.instanceOf = function (obj) {
        return obj && obj['@class'] === RemoteEndpointServiceAccessStrategy.cName;
    };
    RemoteEndpointServiceAccessStrategy.cName = 'org.apereo.cas.services.RemoteEndpointServiceAccessStrategy';
    return RemoteEndpointServiceAccessStrategy;
}(DefaultRegisteredServiceAccessStrategy));

var TimeBasedRegisteredServiceAccessStrategy = (function (_super) {
    __extends(TimeBasedRegisteredServiceAccessStrategy, _super);
    function TimeBasedRegisteredServiceAccessStrategy(strat) {
        var _this = _super.call(this, strat) || this;
        _this['@class'] = TimeBasedRegisteredServiceAccessStrategy.cName;
        return _this;
    }
    TimeBasedRegisteredServiceAccessStrategy.instanceOf = function (obj) {
        return obj && obj['@class'] === TimeBasedRegisteredServiceAccessStrategy.cName;
    };
    TimeBasedRegisteredServiceAccessStrategy.cName = 'org.apereo.cas.services.TimeBasedRegisteredServiceAccessStrategy';
    return TimeBasedRegisteredServiceAccessStrategy;
}(DefaultRegisteredServiceAccessStrategy));

var GrouperRegisteredServiceAccessStrategy = (function (_super) {
    __extends(GrouperRegisteredServiceAccessStrategy, _super);
    function GrouperRegisteredServiceAccessStrategy(strat) {
        var _this = _super.call(this, strat) || this;
        _this['@class'] = GrouperRegisteredServiceAccessStrategy.cName;
        return _this;
    }
    GrouperRegisteredServiceAccessStrategy.instanceOf = function (obj) {
        return obj && obj['@class'] === GrouperRegisteredServiceAccessStrategy.cName;
    };
    GrouperRegisteredServiceAccessStrategy.cName = 'org.apereo.cas.grouper.services.GrouperRegisteredServiceAccessStrategy';
    return GrouperRegisteredServiceAccessStrategy;
}(TimeBasedRegisteredServiceAccessStrategy));

var SurrogateRegisteredServiceAccessStrategy = (function (_super) {
    __extends(SurrogateRegisteredServiceAccessStrategy, _super);
    function SurrogateRegisteredServiceAccessStrategy(strat) {
        var _this = _super.call(this, strat) || this;
        _this['@class'] = SurrogateRegisteredServiceAccessStrategy.cName;
        return _this;
    }
    SurrogateRegisteredServiceAccessStrategy.instanceOf = function (obj) {
        return obj && obj['@class'] === SurrogateRegisteredServiceAccessStrategy.cName;
    };
    SurrogateRegisteredServiceAccessStrategy.cName = 'org.apereo.cas.services.SurrogateRegisteredServiceAccessStrategy';
    return SurrogateRegisteredServiceAccessStrategy;
}(DefaultRegisteredServiceAccessStrategy));



/***/ }),

/***/ "../../../../../src/domain/attribute-filter.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceAttributeFilter */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegisteredServiceChainingAttributeFilter; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return RegisteredServiceRegexAttributeFilter; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return RegisteredServiceMappedRegexAttributeFilter; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return RegisteredServiceReverseMappedRegexAttributeFilter; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "e", function() { return RegisteredServiceScriptedAttributeFilter; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceAttributeFilter = (function () {
    function RegisteredServiceAttributeFilter() {
    }
    return RegisteredServiceAttributeFilter;
}());

var RegisteredServiceChainingAttributeFilter = (function (_super) {
    __extends(RegisteredServiceChainingAttributeFilter, _super);
    function RegisteredServiceChainingAttributeFilter() {
        var _this = _super.call(this) || this;
        _this.filters = [];
        _this['@class'] = RegisteredServiceChainingAttributeFilter.cName;
        return _this;
    }
    RegisteredServiceChainingAttributeFilter.instanceof = function (obj) {
        return obj && obj['@class'] === RegisteredServiceChainingAttributeFilter.cName;
    };
    RegisteredServiceChainingAttributeFilter.cName = 'org.apereo.cas.services.support.RegisteredServiceChainingAttributeFilter';
    return RegisteredServiceChainingAttributeFilter;
}(RegisteredServiceAttributeFilter));

var RegisteredServiceRegexAttributeFilter = (function (_super) {
    __extends(RegisteredServiceRegexAttributeFilter, _super);
    function RegisteredServiceRegexAttributeFilter(filter) {
        var _this = _super.call(this) || this;
        _this['@class'] = RegisteredServiceRegexAttributeFilter.cName;
        return _this;
    }
    RegisteredServiceRegexAttributeFilter.instanceOf = function (obj) {
        return obj && obj['@class'] === RegisteredServiceRegexAttributeFilter.cName;
    };
    RegisteredServiceRegexAttributeFilter.cName = 'org.apereo.cas.services.support.RegisteredServiceRegexAttributeFilter';
    return RegisteredServiceRegexAttributeFilter;
}(RegisteredServiceAttributeFilter));

var RegisteredServiceMappedRegexAttributeFilter = (function (_super) {
    __extends(RegisteredServiceMappedRegexAttributeFilter, _super);
    function RegisteredServiceMappedRegexAttributeFilter() {
        var _this = _super.call(this) || this;
        _this.patterns = new Map();
        _this['@class'] = RegisteredServiceMappedRegexAttributeFilter.cName;
        return _this;
    }
    RegisteredServiceMappedRegexAttributeFilter.instanceof = function (obj) {
        return obj && obj['@class'] === RegisteredServiceMappedRegexAttributeFilter.cName;
    };
    RegisteredServiceMappedRegexAttributeFilter.cName = 'org.apereo.cas.services.support.RegisteredServiceMappedRegexAttributeFilter';
    return RegisteredServiceMappedRegexAttributeFilter;
}(RegisteredServiceAttributeFilter));

var RegisteredServiceReverseMappedRegexAttributeFilter = (function (_super) {
    __extends(RegisteredServiceReverseMappedRegexAttributeFilter, _super);
    function RegisteredServiceReverseMappedRegexAttributeFilter() {
        var _this = _super.call(this) || this;
        _this['@class'] = RegisteredServiceReverseMappedRegexAttributeFilter.cName;
        return _this;
    }
    RegisteredServiceReverseMappedRegexAttributeFilter.instanceof = function (obj) {
        return obj && obj['@class'] === RegisteredServiceReverseMappedRegexAttributeFilter.cName;
    };
    RegisteredServiceReverseMappedRegexAttributeFilter.cName = 'org.apereo.cas.services.support.RegisteredServiceReverseMappedRegexAttributeFilter';
    return RegisteredServiceReverseMappedRegexAttributeFilter;
}(RegisteredServiceMappedRegexAttributeFilter));

var RegisteredServiceScriptedAttributeFilter = (function (_super) {
    __extends(RegisteredServiceScriptedAttributeFilter, _super);
    function RegisteredServiceScriptedAttributeFilter() {
        var _this = _super.call(this) || this;
        _this['@class'] = RegisteredServiceScriptedAttributeFilter.cName;
        return _this;
    }
    RegisteredServiceScriptedAttributeFilter.instanceof = function (obj) {
        return obj && obj['@class'] === RegisteredServiceScriptedAttributeFilter.cName;
    };
    RegisteredServiceScriptedAttributeFilter.cName = 'org.apereo.cas.services.support.RegisteredServiceScriptedAttributeFilter';
    return RegisteredServiceScriptedAttributeFilter;
}(RegisteredServiceAttributeFilter));



/***/ }),

/***/ "../../../../../src/domain/attribute-provider.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceUsernameAttributeProvider */
/* unused harmony export BaseRegisteredServiceUsernameAtttributeProvider */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return DefaultRegisteredServiceUsernameProvider; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return PrincipalAttributeRegisteredServiceUsernameProvider; });
/* unused harmony export ShibbolethCompatiblePersistentIdGenerator */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AnonymousRegisteredServiceUsernameProvider; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceUsernameAttributeProvider = (function () {
    function RegisteredServiceUsernameAttributeProvider() {
    }
    return RegisteredServiceUsernameAttributeProvider;
}());

var BaseRegisteredServiceUsernameAtttributeProvider = (function (_super) {
    __extends(BaseRegisteredServiceUsernameAtttributeProvider, _super);
    function BaseRegisteredServiceUsernameAtttributeProvider(provider) {
        var _this = _super.call(this) || this;
        _this.canonicalizationMode = (provider && provider.canonicalizationMode) || 'NONE';
        _this.encryptUserName = provider && provider.encryptUserName;
        return _this;
    }
    return BaseRegisteredServiceUsernameAtttributeProvider;
}(RegisteredServiceUsernameAttributeProvider));

var DefaultRegisteredServiceUsernameProvider = (function (_super) {
    __extends(DefaultRegisteredServiceUsernameProvider, _super);
    function DefaultRegisteredServiceUsernameProvider(provider) {
        var _this = _super.call(this, provider) || this;
        _this['@class'] = DefaultRegisteredServiceUsernameProvider.cName;
        return _this;
    }
    DefaultRegisteredServiceUsernameProvider.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceUsernameProvider.cName;
    };
    DefaultRegisteredServiceUsernameProvider.cName = 'org.apereo.cas.services.DefaultRegisteredServiceUsernameProvider';
    return DefaultRegisteredServiceUsernameProvider;
}(BaseRegisteredServiceUsernameAtttributeProvider));

var PrincipalAttributeRegisteredServiceUsernameProvider = (function (_super) {
    __extends(PrincipalAttributeRegisteredServiceUsernameProvider, _super);
    function PrincipalAttributeRegisteredServiceUsernameProvider(provider) {
        var _this = _super.call(this, provider) || this;
        _this['@class'] = PrincipalAttributeRegisteredServiceUsernameProvider.cName;
        return _this;
    }
    PrincipalAttributeRegisteredServiceUsernameProvider.instanceOf = function (obj) {
        return obj && obj['@class'] === PrincipalAttributeRegisteredServiceUsernameProvider.cName;
    };
    PrincipalAttributeRegisteredServiceUsernameProvider.cName = 'org.apereo.cas.services.PrincipalAttributeRegisteredServiceUsernameProvider';
    return PrincipalAttributeRegisteredServiceUsernameProvider;
}(BaseRegisteredServiceUsernameAtttributeProvider));

var ShibbolethCompatiblePersistentIdGenerator = (function () {
    function ShibbolethCompatiblePersistentIdGenerator() {
        this['@class'] = ShibbolethCompatiblePersistentIdGenerator.cName;
    }
    ShibbolethCompatiblePersistentIdGenerator.instsanceOf = function (obj) {
        return obj && obj['@class'] === ShibbolethCompatiblePersistentIdGenerator.cName;
    };
    ShibbolethCompatiblePersistentIdGenerator.cName = 'org.apereo.cas.authentication.principal.ShibbolethCompatiblePersistentIdGenerator';
    return ShibbolethCompatiblePersistentIdGenerator;
}());

var AnonymousRegisteredServiceUsernameProvider = (function (_super) {
    __extends(AnonymousRegisteredServiceUsernameProvider, _super);
    function AnonymousRegisteredServiceUsernameProvider() {
        var _this = _super.call(this) || this;
        _this['@class'] = AnonymousRegisteredServiceUsernameProvider.cName;
        _this.persistentIdGenerator = new ShibbolethCompatiblePersistentIdGenerator();
        return _this;
    }
    AnonymousRegisteredServiceUsernameProvider.instanceOf = function (obj) {
        return obj && obj['@class'] === AnonymousRegisteredServiceUsernameProvider.cName;
    };
    AnonymousRegisteredServiceUsernameProvider.cName = 'org.apereo.cas.services.AnonymousRegisteredServiceUsernameAttributeProvider';
    return AnonymousRegisteredServiceUsernameProvider;
}(RegisteredServiceUsernameAttributeProvider));



/***/ }),

/***/ "../../../../../src/domain/attribute-release.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceAttributeReleasePolicy */
/* unused harmony export AbstractRegisteredServiceAttributeReleasePolicy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "g", function() { return ReturnAllAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DenyAllAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "i", function() { return ReturnMappedAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "h", function() { return ReturnAllowedAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "k", function() { return ScriptedRegisteredServiceAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "j", function() { return ReturnRestfulAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return GroovyScriptAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return GroovySamlRegisteredServiceAttributeReleasePolicy; });
/* unused harmony export WsFederationClaimsReleasePolicy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return InCommonRSAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "f", function() { return PatternMatchingEntityIdAttributeReleasePolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "e", function() { return MetadataEntityAttributesAttributeReleasePolicy; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__attribute_repo__ = __webpack_require__("../../../../../src/domain/attribute-repo.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__consent__ = __webpack_require__("../../../../../src/domain/consent.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();


var RegisteredServiceAttributeReleasePolicy = (function () {
    function RegisteredServiceAttributeReleasePolicy(policy) {
        this.attributeFilter = policy && policy.attributeFilter;
        this.principalAttributesRepository = (policy && policy.principalAttributesRepository) || new __WEBPACK_IMPORTED_MODULE_0__attribute_repo__["b" /* DefaultPrincipalAttributesRepository */]();
        this.authorizedToReleaseCredentialPassword = policy && policy.authorizedToReleaseCredentialPassword;
        this.authorizedToReleaseProxyGrantingTicket = policy && policy.authorizedToReleaseProxyGrantingTicket;
        this.excludeDefaultAttributes = policy && policy.excludeDefaultAttributes;
        this.principalIdAttribute = policy && policy.principalIdAttribute;
        this.authorizedToReleaseAuthenticationAttributes = policy && policy.authorizedToReleaseAuthenticationAttributes || true;
        this.consentPolicy = policy && policy.consentPolicy || new __WEBPACK_IMPORTED_MODULE_1__consent__["a" /* DefaultRegisteredServiceConsentPolicy */]();
    }
    return RegisteredServiceAttributeReleasePolicy;
}());

var AbstractRegisteredServiceAttributeReleasePolicy = (function (_super) {
    __extends(AbstractRegisteredServiceAttributeReleasePolicy, _super);
    function AbstractRegisteredServiceAttributeReleasePolicy(policy) {
        return _super.call(this, policy) || this;
    }
    return AbstractRegisteredServiceAttributeReleasePolicy;
}(RegisteredServiceAttributeReleasePolicy));

var ReturnAllAttributeReleasePolicy = (function (_super) {
    __extends(ReturnAllAttributeReleasePolicy, _super);
    function ReturnAllAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = ReturnAllAttributeReleasePolicy.cName;
        return _this;
    }
    ReturnAllAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === this.cName;
    };
    ReturnAllAttributeReleasePolicy.cName = 'org.apereo.cas.services.ReturnAllAttributeReleasePolicy';
    return ReturnAllAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var DenyAllAttributeReleasePolicy = (function (_super) {
    __extends(DenyAllAttributeReleasePolicy, _super);
    function DenyAllAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = DenyAllAttributeReleasePolicy.cName;
        return _this;
    }
    DenyAllAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === DenyAllAttributeReleasePolicy.cName;
    };
    DenyAllAttributeReleasePolicy.cName = 'org.apereo.cas.services.DenyAllAttributeReleasePolicy';
    return DenyAllAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var ReturnMappedAttributeReleasePolicy = (function (_super) {
    __extends(ReturnMappedAttributeReleasePolicy, _super);
    function ReturnMappedAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = ReturnMappedAttributeReleasePolicy.cName;
        return _this;
    }
    ReturnMappedAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === ReturnMappedAttributeReleasePolicy.cName;
    };
    ReturnMappedAttributeReleasePolicy.cName = 'org.apereo.cas.services.ReturnMappedAttributeReleasePolicy';
    return ReturnMappedAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var ReturnAllowedAttributeReleasePolicy = (function (_super) {
    __extends(ReturnAllowedAttributeReleasePolicy, _super);
    function ReturnAllowedAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = ReturnAllowedAttributeReleasePolicy.cName;
        return _this;
    }
    ReturnAllowedAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === ReturnAllowedAttributeReleasePolicy.cName;
    };
    ReturnAllowedAttributeReleasePolicy.cName = 'org.apereo.cas.services.ReturnAllowedAttributeReleasePolicy';
    return ReturnAllowedAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var ScriptedRegisteredServiceAttributeReleasePolicy = (function (_super) {
    __extends(ScriptedRegisteredServiceAttributeReleasePolicy, _super);
    function ScriptedRegisteredServiceAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = ScriptedRegisteredServiceAttributeReleasePolicy.cName;
        return _this;
    }
    ScriptedRegisteredServiceAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === ScriptedRegisteredServiceAttributeReleasePolicy.cName;
    };
    ScriptedRegisteredServiceAttributeReleasePolicy.cName = 'org.apereo.cas.services.ScriptedRegisteredServiceAttributeReleasePolicy';
    return ScriptedRegisteredServiceAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var ReturnRestfulAttributeReleasePolicy = (function (_super) {
    __extends(ReturnRestfulAttributeReleasePolicy, _super);
    function ReturnRestfulAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = ReturnRestfulAttributeReleasePolicy.cName;
        return _this;
    }
    ReturnRestfulAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === ReturnRestfulAttributeReleasePolicy.cName;
    };
    ReturnRestfulAttributeReleasePolicy.cName = 'org.apereo.cas.services.ReturnRestfulAttributeReleasePolicy';
    return ReturnRestfulAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var GroovyScriptAttributeReleasePolicy = (function (_super) {
    __extends(GroovyScriptAttributeReleasePolicy, _super);
    function GroovyScriptAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = GroovyScriptAttributeReleasePolicy.cName;
        return _this;
    }
    GroovyScriptAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === GroovyScriptAttributeReleasePolicy.cName;
    };
    GroovyScriptAttributeReleasePolicy.cName = 'org.apereo.cas.services.GroovyScriptAttributeReleasePolicy';
    return GroovyScriptAttributeReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var GroovySamlRegisteredServiceAttributeReleasePolicy = (function (_super) {
    __extends(GroovySamlRegisteredServiceAttributeReleasePolicy, _super);
    function GroovySamlRegisteredServiceAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = GroovySamlRegisteredServiceAttributeReleasePolicy.cName;
        return _this;
    }
    GroovySamlRegisteredServiceAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === GroovySamlRegisteredServiceAttributeReleasePolicy.cName;
    };
    GroovySamlRegisteredServiceAttributeReleasePolicy.cName = 'org.apereo.cas.support.saml.services.GroovySamlRegisteredServiceAttributeReleasePolicy';
    return GroovySamlRegisteredServiceAttributeReleasePolicy;
}(ReturnAllowedAttributeReleasePolicy));

var WsFederationClaimsReleasePolicy = (function (_super) {
    __extends(WsFederationClaimsReleasePolicy, _super);
    function WsFederationClaimsReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = WsFederationClaimsReleasePolicy.cName;
        return _this;
    }
    WsFederationClaimsReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === WsFederationClaimsReleasePolicy.cName;
    };
    WsFederationClaimsReleasePolicy.cName = 'org.apereo.cas.ws.idp.services.WsFederationClaimsReleasePolicy';
    return WsFederationClaimsReleasePolicy;
}(AbstractRegisteredServiceAttributeReleasePolicy));

var InCommonRSAttributeReleasePolicy = (function (_super) {
    __extends(InCommonRSAttributeReleasePolicy, _super);
    function InCommonRSAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = InCommonRSAttributeReleasePolicy.cName;
        return _this;
    }
    InCommonRSAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === InCommonRSAttributeReleasePolicy.cName;
    };
    InCommonRSAttributeReleasePolicy.cName = 'org.apereo.cas.support.saml.services.InCommonRSAttributeReleasePolicy';
    return InCommonRSAttributeReleasePolicy;
}(RegisteredServiceAttributeReleasePolicy));

var PatternMatchingEntityIdAttributeReleasePolicy = (function (_super) {
    __extends(PatternMatchingEntityIdAttributeReleasePolicy, _super);
    function PatternMatchingEntityIdAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = PatternMatchingEntityIdAttributeReleasePolicy.cName;
        return _this;
    }
    PatternMatchingEntityIdAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === PatternMatchingEntityIdAttributeReleasePolicy.cName;
    };
    PatternMatchingEntityIdAttributeReleasePolicy.cName = 'org.apereo.cas.support.saml.services.PatternMatchingEntityIdAttributeReleasePolicy';
    return PatternMatchingEntityIdAttributeReleasePolicy;
}(RegisteredServiceAttributeReleasePolicy));

var MetadataEntityAttributesAttributeReleasePolicy = (function (_super) {
    __extends(MetadataEntityAttributesAttributeReleasePolicy, _super);
    function MetadataEntityAttributesAttributeReleasePolicy(policy) {
        var _this = _super.call(this, policy) || this;
        _this['@class'] = MetadataEntityAttributesAttributeReleasePolicy.cName;
        return _this;
    }
    MetadataEntityAttributesAttributeReleasePolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === MetadataEntityAttributesAttributeReleasePolicy.cName;
    };
    MetadataEntityAttributesAttributeReleasePolicy.cName = 'org.apereo.cas.support.saml.services.MetadataEntityAttributesAttributeReleasePolicy';
    return MetadataEntityAttributesAttributeReleasePolicy;
}(ReturnAllowedAttributeReleasePolicy));



/***/ }),

/***/ "../../../../../src/domain/attribute-repo.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export PrincipalAttributesRepository */
/* unused harmony export AbstractPrincipalAttributesRepository */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return DefaultPrincipalAttributesRepository; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CachingPrincipalAttributesRepository; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var PrincipalAttributesRepository = (function () {
    function PrincipalAttributesRepository() {
    }
    return PrincipalAttributesRepository;
}());

var AbstractPrincipalAttributesRepository = (function (_super) {
    __extends(AbstractPrincipalAttributesRepository, _super);
    function AbstractPrincipalAttributesRepository() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return AbstractPrincipalAttributesRepository;
}(PrincipalAttributesRepository));

var DefaultPrincipalAttributesRepository = (function (_super) {
    __extends(DefaultPrincipalAttributesRepository, _super);
    function DefaultPrincipalAttributesRepository() {
        var _this = _super.call(this) || this;
        _this['@class'] = DefaultPrincipalAttributesRepository.cName;
        return _this;
    }
    DefaultPrincipalAttributesRepository.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultPrincipalAttributesRepository.cName;
    };
    DefaultPrincipalAttributesRepository.cName = 'org.apereo.cas.authentication.principal.DefaultPrincipalAttributesRepository';
    return DefaultPrincipalAttributesRepository;
}(AbstractPrincipalAttributesRepository));

var CachingPrincipalAttributesRepository = (function (_super) {
    __extends(CachingPrincipalAttributesRepository, _super);
    function CachingPrincipalAttributesRepository() {
        var _this = _super.call(this) || this;
        _this['@class'] = CachingPrincipalAttributesRepository.cName;
        return _this;
    }
    CachingPrincipalAttributesRepository.instanceOf = function (obj) {
        return obj && obj['@class'] === CachingPrincipalAttributesRepository.cName;
    };
    CachingPrincipalAttributesRepository.cName = 'org.apereo.cas.authentication.principal.cache.CachingPrincipalAttributesRepository';
    return CachingPrincipalAttributesRepository;
}(AbstractPrincipalAttributesRepository));



/***/ }),

/***/ "../../../../../src/domain/consent.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceConsentPolicy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultRegisteredServiceConsentPolicy; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceConsentPolicy = (function () {
    function RegisteredServiceConsentPolicy() {
        this.enabled = true;
        this['@class'] = RegisteredServiceConsentPolicy.cName;
    }
    RegisteredServiceConsentPolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === RegisteredServiceConsentPolicy.cName;
    };
    RegisteredServiceConsentPolicy.cName = 'org.apereo.cas.services.RegisteredServiceConsentPolicy';
    return RegisteredServiceConsentPolicy;
}());

var DefaultRegisteredServiceConsentPolicy = (function (_super) {
    __extends(DefaultRegisteredServiceConsentPolicy, _super);
    function DefaultRegisteredServiceConsentPolicy() {
        var _this = _super.call(this) || this;
        _this['@class'] = DefaultRegisteredServiceConsentPolicy.cName;
        return _this;
    }
    DefaultRegisteredServiceConsentPolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceConsentPolicy.cName;
    };
    DefaultRegisteredServiceConsentPolicy.cName = 'org.apereo.cas.services.consent.DefaultRegisteredServiceConsentPolicy';
    return DefaultRegisteredServiceConsentPolicy;
}(RegisteredServiceConsentPolicy));



/***/ }),

/***/ "../../../../../src/domain/contact.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceContact */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultRegisteredServiceContact; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceContact = (function () {
    function RegisteredServiceContact() {
    }
    return RegisteredServiceContact;
}());

var DefaultRegisteredServiceContact = (function (_super) {
    __extends(DefaultRegisteredServiceContact, _super);
    function DefaultRegisteredServiceContact() {
        var _this = _super.call(this) || this;
        _this['@class'] = DefaultRegisteredServiceContact.cName;
        return _this;
    }
    DefaultRegisteredServiceContact.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceContact.cName;
    };
    DefaultRegisteredServiceContact.cName = 'org.apereo.cas.services.DefaultRegisteredServiceContact';
    return DefaultRegisteredServiceContact;
}(RegisteredServiceContact));



/***/ }),

/***/ "../../../../../src/domain/expiration.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceExpirationPolicy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultRegisteredServiceExpirationPolicy; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceExpirationPolicy = (function () {
    function RegisteredServiceExpirationPolicy() {
    }
    return RegisteredServiceExpirationPolicy;
}());

var DefaultRegisteredServiceExpirationPolicy = (function (_super) {
    __extends(DefaultRegisteredServiceExpirationPolicy, _super);
    function DefaultRegisteredServiceExpirationPolicy() {
        var _this = _super.call(this) || this;
        _this['@class'] = DefaultRegisteredServiceExpirationPolicy.cName;
        return _this;
    }
    DefaultRegisteredServiceExpirationPolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceExpirationPolicy.cName;
    };
    DefaultRegisteredServiceExpirationPolicy.cName = 'org.apereo.cas.services.DefaultRegisteredServiceExpirationPolicy';
    return DefaultRegisteredServiceExpirationPolicy;
}(RegisteredServiceExpirationPolicy));



/***/ }),

/***/ "../../../../../src/domain/form-data.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormData; });
var FormData = (function () {
    function FormData() {
        this.availableAttributes = [];
    }
    return FormData;
}());



/***/ }),

/***/ "../../../../../src/domain/multifactor.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceMultifactorPolicy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultRegisteredServiceMultifactorPolicy; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceMultifactorPolicy = (function () {
    function RegisteredServiceMultifactorPolicy() {
    }
    return RegisteredServiceMultifactorPolicy;
}());

var DefaultRegisteredServiceMultifactorPolicy = (function (_super) {
    __extends(DefaultRegisteredServiceMultifactorPolicy, _super);
    function DefaultRegisteredServiceMultifactorPolicy() {
        var _this = _super.call(this) || this;
        _this.failureMode = 'NOT_SET';
        _this['@class'] = DefaultRegisteredServiceMultifactorPolicy.cName;
        return _this;
    }
    DefaultRegisteredServiceMultifactorPolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceMultifactorPolicy.cName;
    };
    DefaultRegisteredServiceMultifactorPolicy.cName = 'org.apereo.cas.services.DefaultRegisteredServiceMultifactorPolicy';
    return DefaultRegisteredServiceMultifactorPolicy;
}(RegisteredServiceMultifactorPolicy));



/***/ }),

/***/ "../../../../../src/domain/oauth-service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OAuthRegisteredService; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return OidcRegisteredService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__registered_service__ = __webpack_require__("../../../../../src/domain/registered-service.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var OAuthRegisteredService = (function (_super) {
    __extends(OAuthRegisteredService, _super);
    function OAuthRegisteredService(service) {
        var _this = _super.call(this, service) || this;
        _this['@class'] = OAuthRegisteredService.cName;
        var s = service;
        _this.clientSecret = s && s.clientSecret;
        _this.clientId = s && s.clientId;
        _this.bypassApprovalPrompt = s && s.bypassApprovalPrompt;
        _this.generateRefreshToken = s && s.generateRefreshToken;
        _this.jsonFormat = s && s.jsonFormat;
        _this.supportedGrantTypes = s && s.supportedGrantTypes;
        _this.supportedResponseTypes = s && s.supportedResponseTypes;
        return _this;
    }
    OAuthRegisteredService.instanceOf = function (obj) {
        return obj && obj['@class'] === OAuthRegisteredService.cName;
    };
    OAuthRegisteredService.cName = 'org.apereo.cas.support.oauth.services.OAuthRegisteredService';
    return OAuthRegisteredService;
}(__WEBPACK_IMPORTED_MODULE_0__registered_service__["a" /* RegexRegisteredService */]));

var OidcRegisteredService = (function (_super) {
    __extends(OidcRegisteredService, _super);
    function OidcRegisteredService(service) {
        var _this = _super.call(this, service) || this;
        _this.jsonFormat = true;
        _this.signIdToken = true;
        _this.subjectType = 'PUBLIC';
        _this['@class'] = OidcRegisteredService.cName;
        return _this;
    }
    OidcRegisteredService.instanceOf = function (obj) {
        return obj && obj['@class'] === OidcRegisteredService.cName;
    };
    OidcRegisteredService.cName = 'org.apereo.cas.services.OidcRegisteredService';
    return OidcRegisteredService;
}(OAuthRegisteredService));



/***/ }),

/***/ "../../../../../src/domain/property.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceProperty */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DefaultRegisteredServiceProperty; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceProperty = (function () {
    function RegisteredServiceProperty() {
        this.values = [];
    }
    return RegisteredServiceProperty;
}());

var DefaultRegisteredServiceProperty = (function (_super) {
    __extends(DefaultRegisteredServiceProperty, _super);
    function DefaultRegisteredServiceProperty() {
        var _this = _super.call(this) || this;
        _this['@class'] = DefaultRegisteredServiceProperty.cName;
        return _this;
    }
    DefaultRegisteredServiceProperty.instanceOf = function (obj) {
        return obj && obj['@class'] === DefaultRegisteredServiceProperty.cName;
    };
    DefaultRegisteredServiceProperty.cName = 'org.apereo.cas.services.DefaultRegisteredServiceProperty';
    return DefaultRegisteredServiceProperty;
}(RegisteredServiceProperty));



/***/ }),

/***/ "../../../../../src/domain/proxy-policy,ts.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServiceProxyPolicy */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return RegexMatchingRegisteredServiceProxyPolicy; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RefuseRegisteredServiceProxyPolicy; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServiceProxyPolicy = (function () {
    function RegisteredServiceProxyPolicy() {
    }
    return RegisteredServiceProxyPolicy;
}());

var RegexMatchingRegisteredServiceProxyPolicy = (function (_super) {
    __extends(RegexMatchingRegisteredServiceProxyPolicy, _super);
    function RegexMatchingRegisteredServiceProxyPolicy() {
        var _this = _super.call(this) || this;
        _this['@class'] = RegexMatchingRegisteredServiceProxyPolicy.cName;
        return _this;
    }
    RegexMatchingRegisteredServiceProxyPolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === RegexMatchingRegisteredServiceProxyPolicy.cName;
    };
    RegexMatchingRegisteredServiceProxyPolicy.cName = 'org.apereo.cas.services.RegexMatchingRegisteredServiceProxyPolicy';
    return RegexMatchingRegisteredServiceProxyPolicy;
}(RegisteredServiceProxyPolicy));

var RefuseRegisteredServiceProxyPolicy = (function (_super) {
    __extends(RefuseRegisteredServiceProxyPolicy, _super);
    function RefuseRegisteredServiceProxyPolicy() {
        var _this = _super.call(this) || this;
        _this['@class'] = RefuseRegisteredServiceProxyPolicy.cName;
        return _this;
    }
    RefuseRegisteredServiceProxyPolicy.instanceOf = function (obj) {
        return obj && obj['@class'] === RefuseRegisteredServiceProxyPolicy.cName;
    };
    RefuseRegisteredServiceProxyPolicy.cName = 'org.apereo.cas.services.RefuseRegisteredServiceProxyPolicy';
    return RefuseRegisteredServiceProxyPolicy;
}(RegisteredServiceProxyPolicy));



/***/ }),

/***/ "../../../../../src/domain/public-key.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredServicePublicKey */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegisteredServicePublicKeyImpl; });
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var RegisteredServicePublicKey = (function () {
    function RegisteredServicePublicKey() {
    }
    return RegisteredServicePublicKey;
}());

var RegisteredServicePublicKeyImpl = (function (_super) {
    __extends(RegisteredServicePublicKeyImpl, _super);
    function RegisteredServicePublicKeyImpl() {
        var _this = _super.call(this) || this;
        _this.algorithm = 'RSA';
        _this['@class'] = RegisteredServicePublicKeyImpl.cName;
        return _this;
    }
    RegisteredServicePublicKeyImpl.instanceOf = function (obj) {
        return obj && obj['@class'] === RegisteredServicePublicKeyImpl.cName;
    };
    RegisteredServicePublicKeyImpl.cName = 'org.apereo.cas.services.RegisteredServicePublicKeyImpl';
    return RegisteredServicePublicKeyImpl;
}(RegisteredServicePublicKey));



/***/ }),

/***/ "../../../../../src/domain/registered-service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export RegisteredService */
/* unused harmony export AbstractRegisteredService */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegexRegisteredService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__access_strategy__ = __webpack_require__("../../../../../src/domain/access-strategy.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__multifactor__ = __webpack_require__("../../../../../src/domain/multifactor.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__proxy_policy_ts__ = __webpack_require__("../../../../../src/domain/proxy-policy,ts.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__attribute_provider__ = __webpack_require__("../../../../../src/domain/attribute-provider.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__attribute_release__ = __webpack_require__("../../../../../src/domain/attribute-release.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__expiration__ = __webpack_require__("../../../../../src/domain/expiration.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();






var RegisteredService = (function () {
    function RegisteredService(service) {
        this.requiredHandlers = [];
        this.serviceId = service && service.serviceId;
        this.name = service && service.name;
        this.theme = service && service.theme;
        this.informationUrl = service && service.informationUrl;
        this.privacyUrl = service && service.privacyUrl;
        this.id = (service && service.id) || -1;
        this.description = service && service.description;
        this.proxyPolicy = (service && service.proxyPolicy) || new __WEBPACK_IMPORTED_MODULE_2__proxy_policy_ts__["a" /* RefuseRegisteredServiceProxyPolicy */]();
        this.evaluationOrder = (service && service.evaluationOrder) || -1;
        this.usernameAttributeProvider = (service && service.usernameAttributeProvider) || new __WEBPACK_IMPORTED_MODULE_3__attribute_provider__["b" /* DefaultRegisteredServiceUsernameProvider */]();
        this.requiredHandlers = service && service.requiredHandlers;
        this.attributeReleasePolicy = (service && service.attributeReleasePolicy) || new __WEBPACK_IMPORTED_MODULE_4__attribute_release__["h" /* ReturnAllowedAttributeReleasePolicy */]();
        this.multifactorPolicy = (service && service.multifactorPolicy) || new __WEBPACK_IMPORTED_MODULE_1__multifactor__["a" /* DefaultRegisteredServiceMultifactorPolicy */]();
        this.logo = service && service.logo;
        this.logoutUrl = service && service.logoutUrl;
        this.logoutType = (service && service.logoutType) || 'BACK_CHANNEL';
        this.accessStrategy = (service && service.accessStrategy) || new __WEBPACK_IMPORTED_MODULE_0__access_strategy__["a" /* DefaultRegisteredServiceAccessStrategy */]();
        this.publicKey = service && service.publicKey;
        this.properties = service && service.properties;
        this.contacts = service && service.contacts;
        this.expirationPolicy = (service && service.expirationPolicy) || new __WEBPACK_IMPORTED_MODULE_5__expiration__["a" /* DefaultRegisteredServiceExpirationPolicy */]();
    }
    return RegisteredService;
}());

var AbstractRegisteredService = (function (_super) {
    __extends(AbstractRegisteredService, _super);
    function AbstractRegisteredService(service) {
        return _super.call(this, service) || this;
    }
    return AbstractRegisteredService;
}(RegisteredService));

var RegexRegisteredService = (function (_super) {
    __extends(RegexRegisteredService, _super);
    function RegexRegisteredService(service) {
        var _this = _super.call(this, service) || this;
        _this['@class'] = RegexRegisteredService.cName;
        return _this;
    }
    RegexRegisteredService.instanceOf = function (obj) {
        return obj && obj['@class'] === RegexRegisteredService.cName;
    };
    RegexRegisteredService.cName = 'org.apereo.cas.services.RegexRegisteredService';
    return RegexRegisteredService;
}(AbstractRegisteredService));



/***/ }),

/***/ "../../../../../src/domain/saml-service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SamlRegisteredService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__registered_service__ = __webpack_require__("../../../../../src/domain/registered-service.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var SamlRegisteredService = (function (_super) {
    __extends(SamlRegisteredService, _super);
    function SamlRegisteredService(service) {
        var _this = _super.call(this, service) || this;
        _this.metadataExpirationDuration = 'PT60M';
        _this.metadataCriteriaRoles = 'SPSSODescriptor';
        _this.signResponses = true;
        _this.signingCredentialType = 'BASIC';
        _this.metadataCriteriaRemoveEmptyEntitiesDescriptors = true;
        _this.metadataCriteriaRemoveRolelessEntityDescriptors = true;
        _this.skipGeneratingSubjectConfirmationNotBefore = true;
        _this['@class'] = SamlRegisteredService.cName;
        return _this;
    }
    SamlRegisteredService.instanceOf = function (obj) {
        return obj && obj['@class'] === SamlRegisteredService.cName;
    };
    SamlRegisteredService.cName = 'org.apereo.cas.support.saml.services.SamlRegisteredService';
    return SamlRegisteredService;
}(__WEBPACK_IMPORTED_MODULE_0__registered_service__["a" /* RegexRegisteredService */]));



/***/ }),

/***/ "../../../../../src/domain/wsed-service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WSFederationRegisterdService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__registered_service__ = __webpack_require__("../../../../../src/domain/registered-service.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var WSFederationRegisterdService = (function (_super) {
    __extends(WSFederationRegisterdService, _super);
    function WSFederationRegisterdService(service) {
        var _this = _super.call(this, service) || this;
        _this['@class'] = WSFederationRegisterdService.cName;
        return _this;
    }
    WSFederationRegisterdService.instanceOf = function (obj) {
        return obj && obj['@class'] === WSFederationRegisterdService.cName;
    };
    WSFederationRegisterdService.cName = 'org.apereo.cas.ws.idp.services.WSFederationRegisteredService';
    return WSFederationRegisterdService;
}(__WEBPACK_IMPORTED_MODULE_0__registered_service__["a" /* RegexRegisteredService */]));



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_rxjs_add_operator_toPromise__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/toPromise.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_rxjs_add_operator_toPromise___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_rxjs_add_operator_toPromise__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_hammerjs__ = __webpack_require__("../../../../hammerjs/hammer.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_hammerjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_hammerjs__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");






if (__WEBPACK_IMPORTED_MODULE_4__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_3__angular_core__["_17" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_2__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_5__app_app_module__["a" /* AppModule */]);


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map