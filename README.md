# Data-Usage
This app showcases the multi module architecture using Kotlin, Jetpack Compose and other technology stacks as listed below
to display mobile data usage across years and quarters.

## Technical Stack
- Multi module Architecture
- Jetpack Compose
- Kotlin
- MVVM architecture
- Room DB
- Retrofit
- Koin for Dependency Injection
- Kotlin flows
- Compose/UI testing
- Unit Testing with mokito

## Screens
### Year Screen

A Screen showing the total amount of data usage for each year.

![YearScreen](./screenshots/YearScreen_1.png)

### Year Details Screen (Quarter Screen)

A screen showing the amount of data usage for each quarter for a selected year.<br>
It is possible to scroll left/right between different years

![YearDetailScreen](./screenshots/YearDetailsScreen_1.png)

## Event Logging Mechanism

When a specific year's details is shown in UI. It is tracked in event logging.<br>
This is illustrated in below logs
![EventLogging](./screenshots/EventLoggingLogs.png)

## Unit Testing (Instrumented Tests)

### features/consumption/years

Tests written inside``src/androidTest/kotlin`` within ``features/consumption/years`` module.<br>
Sample Test result below:
![YearScreenViewModelTestResults](./screenshots/YearScreenViewModelTestResults.png)


### features/consumption/qtr

Tests written inside``src/androidTest/kotlin`` within ``features/consumption/qtr`` module.<br>
Sample Test result below:
![QtrScreenViewModelTestResults](./screenshots/QtrScreenViewModelTestResults.png)


### core/repository
### core/data/datasource/local
### core/data/datasource/remote

## Compose UI testing (Emulator Tests)

### app 

