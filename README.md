# r_android_template
> Recruitment task for junior mobile developer position in bitcomp

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)

## General info
App providing information about estates


## Technologies
* Kotlin 
* DataStore
* coroutines
* Hilt
* Robolectric Test Runner
* NavigationUI


## Setup


## Code Examples
Datastore example:
`    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
    companion object {
        val ID = intPreferencesKey("id")
    }`
    

## Features
List of features ready and TODOs for future development
* Estates List
* Button which show saved estate number 
* Save estate id on item click
* Unit tests


## Status
Project is: _Finished_

## Inspiration
Recruitment task for junior mobile developer position in bitcomp
