Api Documentation
=================
Api Documentation

**Version:** 1.0

**Terms of service:**  
urn:tos


**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### /api/auth
---
##### ***POST***
**Summary:** createAuthenticationToken

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| authenticationRequest | body | authenticationRequest | Yes | [JwtAuthenticationRequest](#jwtauthenticationrequest) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [JwtAuthenticationResponse](#jwtauthenticationresponse) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user
---
##### ***GET***
**Summary:** getAuthenticatedUser

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [UserDto](#userdto) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/account
---
##### ***GET***
**Summary:** getCurrentUserEntityList

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [AccountDto](#accountdto) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***POST***
**Summary:** createEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [AccountDto](#accountdto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/account/edit
---
##### ***POST***
**Summary:** updateAccountForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [AccountDto](#accountdto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/account/remove
---
##### ***POST***
**Summary:** removeEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [BaseDto](#basedto) |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

### /api/user/account/types
---
##### ***GET***
**Summary:** getAccountTypes

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ string ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/account/{id}
---
##### ***GET***
**Summary:** getCurrentUserEntityById

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [AccountDto](#accountdto) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/category
---
##### ***GET***
**Summary:** getCurrentUserEntityList

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [IdAndValueDto](#idandvaluedto) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***POST***
**Summary:** createEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [IdAndValueDto](#idandvaluedto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/category/edit
---
##### ***POST***
**Summary:** updateAccountForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [IdAndValueDto](#idandvaluedto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/category/remove
---
##### ***POST***
**Summary:** removeEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [BaseDto](#basedto) |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

### /api/user/category/{id}
---
##### ***GET***
**Summary:** getCurrentUserEntityById

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [IdAndValueDto](#idandvaluedto) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/metadata/searchableEntities
---
##### ***GET***
**Summary:** getSearchableEntities

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [SearchableEntitiesDto](#searchableentitiesdto) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/payee
---
##### ***GET***
**Summary:** getCurrentUserEntityList

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [IdAndValueDto](#idandvaluedto) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***POST***
**Summary:** createEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [IdAndValueDto](#idandvaluedto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/payee/edit
---
##### ***POST***
**Summary:** updateAccountForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [IdAndValueDto](#idandvaluedto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/payee/remove
---
##### ***POST***
**Summary:** removeEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [BaseDto](#basedto) |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

### /api/user/payee/{id}
---
##### ***GET***
**Summary:** getCurrentUserEntityById

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [IdAndValueDto](#idandvaluedto) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/transaction
---
##### ***GET***
**Summary:** getCurrentUserEntityList

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [TransactionDto](#transactiondto) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***POST***
**Summary:** createEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [TransactionDto](#transactiondto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/transaction/edit
---
##### ***POST***
**Summary:** updateAccountForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [TransactionDto](#transactiondto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [BaseDto](#basedto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/transaction/filter
---
##### ***POST***
**Summary:** getCurrentUserEntityListByFilter

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| transactionFilterDto | body | transactionFilterDto | Yes | [TransactionFilterDto](#transactionfilterdto) |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [TransactionListDto](#transactionlistdto) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/user/transaction/remove
---
##### ***POST***
**Summary:** removeEntityForCurrentUser

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| dto | body | dto | Yes | [BaseDto](#basedto) |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

### /api/user/transaction/{id}
---
##### ***GET***
**Summary:** getCurrentUserEntityById

**Parameters**

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [TransactionDto](#transactiondto) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /error
---
##### ***GET***
**Summary:** errorHtml

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ModelAndView](#modelandview) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***POST***
**Summary:** errorHtml

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ModelAndView](#modelandview) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***PUT***
**Summary:** errorHtml

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ModelAndView](#modelandview) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### ***DELETE***
**Summary:** errorHtml

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ModelAndView](#modelandview) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

##### ***OPTIONS***
**Summary:** errorHtml

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ModelAndView](#modelandview) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

##### ***PATCH***
**Summary:** errorHtml

**Responses**

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ModelAndView](#modelandview) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### Models
---

### AccountDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| active | boolean |  | No |
| amount | number |  | No |
| id | string |  | No |
| name | string |  | No |
| notes | string |  | No |
| owner | [UserDto](#userdto) |  | No |
| type | string |  | No |

### BaseDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |

### IdAndValueDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| value | string |  | No |

### JwtAuthenticationRequest  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| password | string |  | No |
| username | string |  | No |

### JwtAuthenticationResponse  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| token | string |  | No |

### ModelAndView  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| empty | boolean |  | No |
| model | object |  | No |
| modelMap | object |  | No |
| reference | boolean |  | No |
| status | string |  | No |
| view | [View](#view) |  | No |
| viewName | string |  | No |

### SearchableEntitiesDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| accountNames | [ string ] |  | No |
| categoryNames | [ string ] |  | No |
| payeeNames | [ string ] |  | No |

### TransactionDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| account | [IdAndValueDto](#idandvaluedto) |  | No |
| amount | number |  | No |
| category | [IdAndValueDto](#idandvaluedto) |  | No |
| date | string |  | No |
| id | string |  | No |
| note | string |  | No |
| payee | [IdAndValueDto](#idandvaluedto) |  | No |

### TransactionFilterDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| accountNames | [ string ] |  | No |
| categoryNames | [ string ] |  | No |
| endDate | string |  | No |
| payeeNames | [ string ] |  | No |
| startDate | string |  | No |

### TransactionListDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| transactions | [ [TransactionDto](#transactiondto) ] |  | No |
| transactionsCount | integer |  | No |

### UserDto  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdDate | string |  | No |
| email | string |  | No |
| fullName | string |  | No |
| id | string |  | No |
| username | string |  | No |

### View  

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| contentType | string |  | No |