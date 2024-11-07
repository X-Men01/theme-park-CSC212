# Theme Park Management System

This repository contains a Java-based implementation of a Theme Park Management System, developed as part of the CSC212 Data Structures course. The system manages visitor information, categorizes them based on their region and VIP status, and enables several operations to retrieve and analyze visitor data efficiently.



## Overview

This project simulates a theme park management system that keeps track of visitor data. Each visitor is associated with specific attributes like name, VIP status, region, phone number, and their order of visiting various kingdoms. The system allows retrieving and analyzing visitor information for marketing and operational purposes. For instance, the system can identify visitors by their last name, count visitors by region, sort regions by visitor count, and check VIP visitor locations.

## Data Structures Used

1. **Linked List**: Represents a list of regions, each containing a sublist of visitors.
2. **Stack (ArrayStack.java)**: Manages the order of kingdoms visited by each visitor.
3. **Custom Classes**: 
   - `regInfo`: Holds data specific to each region.
   - `visitorInfo`: Stores individual visitor details.
   - `visitorType`: Differentiates between VIP and regular visitors.

## Operations Implemented

### Core Functions
The following are the main operations implemented as part of the Theme Park ADT:
1. **Search by Last Name**: Finds and displays visitors by their last name.
2. **Count Regions**: Displays the total number of regions represented by the visitors.
3. **Sort Regions by Visitor Count**: Lists regions in descending order based on visitor numbers.
4. **Count VIPs in Region**: Shows the total number of VIP visitors from a specified region.
5. **Display VIP Locations**: Prints the current location of all VIP visitors.
6. **Check VIP Location**: Verifies if two VIP visitors are in the same kingdom.
7. **Check Regular Visitor Order**: Confirms if two regular visitors visited kingdoms in the same order.

### Supporting Operations
- **Read and Store Data from File**: Reads visitor data from a file and organizes it into regions and types.
- **Sort Regions (Merge Sort)**: Utilizes merge sort to sort regions by visitor count.


java -version
