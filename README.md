# Newbie
An online Job recruitments portal for students

## Introduction
Newbie is a web based online job management portal that focuses on recruiting students for short term based jobs or tasks and serves as a resume builder. 
It is a platform that gradually introduces students to real-life.

## Scope of the System
Organizations/Recruiters and Students register on the portal to be approved by the admin based on some criteria’s.

Organizations create a job post on the portal, notifications will be sent to student if job post matches the filter criteria created by the student.

Students can apply for job and their profile will be automatically forwarded to the recruiters.

Once a student get recruited by the organization, and completes the job, organizations and students can create review on the job post and the job is automatically added to the student profile which can be downloaded in PDF format as a CV.

## Models

* Base
* Users
* Company
* Staff
* Skill
* Role
* Jobs
* Reviews
* Application
* Request
* Institution
* Degree

## How Newbie Works

Once a student or an organization register on the platform, the admin is notified via email of a pending request; the admin can either reject request if criteria is not met 
or approved. If the request is approved by the admin, an email notification is sent to the initiator of request to inform of the approval.

An approved student can search for jobs on his/her dashboard and also set a search filter for jobs an be notified once a job that matches request is posted; if a student applied for a job post, his application is sent to the recruiters and application status change to *applied* and a notification will be sent to students with application id for easier tracking; once a recruiter viewed application, its status changes to *inReview* and notification sent and when application is accepted or rejected; its status changes to either *Recruited* or *Rejected* and notification is sent. Once a student is done on project, the student will give review on the experienced gained on the job and also on the work ethics of the company.

An organization are expected to create an admin on the platform once approved; the company-admin will be responsible for creating job post, creating recruiters and assigning recruiters to jobs. A company recriuter manages the recruitment process and recruits students for the job. Once the job/project is done, the recruiter/company-admin gives review on the work ethics of student.

Every job done by the student are added to the student profile and can be downloaded in form of a resume.






