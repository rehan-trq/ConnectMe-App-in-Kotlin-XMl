## ConnectMe
ConnectMe is a social networking Android application built in Kotlin with XML-based UI. It enables users to register, log in, view and edit their profiles, chat in real-time, post updates, and more.
## Overview
ConnectMe is a semester project for CS 4039: Software for Mobile Devices. It demonstrates key Android development concepts such as:

1. Kotlin for business logic
2. XML layouts for UI
3. RecyclerView for lists (posts, chats, followers, etc.)
4. BottomNavigationView for navigation
5. ScrollView and nested RecyclerViews
6. GitHub version control and Espresso tests

## Features
1. User Authentication: Login and register flows.
2. Profile Management: Edit profile picture, bio, and personal details.
3. Social Feed: Horizontal stories and vertical posts feed.
4. Vanish Mode: Messages disappear after a set time.
5. Calling: UI for audio/video call (mock or real).
6. New Post: Select images, add captions, share.
7. Followers/Following: Show lists with a toggle and search bar.
8. GitHub Version Control: Each screen has its own commit.

## Architecture
1. Kotlin as the main language.
2. XML layouts for the UI.
3. RecyclerView for lists (posts, followers, stories).
4. ConstraintLayout and CoordinatorLayout for main containers.

## Setup
1. Clone the repo
2. Open the project in Android Studio.
3. Build & Run on an emulator or physical device with Android SDK 21+.

## How to Use
1. Register a new account (if not existing).
2. Login with your credentials.
3. Home Screen:
View stories horizontally.
Scroll through posts vertically.
Tap DM to open direct messages.
4. Profile:
Tap Profile icon in the bottom navigation.
Edit profile or view posts grid.
5. New Post:
Tap + in bottom navigation to open new post screen.
Select images, add caption, tap Share.

## Testing
1. We use Espresso for UI testing. Two example test cases:

2. Navigation Test: Verifies tapping a button leads to the correct screen.
## How to Test
In Android Studio: Right-click the androidTest package → Run 'All Tests'
