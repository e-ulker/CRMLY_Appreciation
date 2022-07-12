

  # TC06 #bug
  @run
  @REM-1043
  Scenario: Verify that user shouldn't be able to attach link that have link text but no URL by clicking on the link icon.
  When User clicks Appreciation subheading from More tabb
  And User clicks link iconn
  And User enters link text "google" and linkk URL ""
  And User clicks Save buttonn
  Then Verify that user shouldn't be able to attach link "google" without linkk URL






    #TC07 #bug

  @REM-1044
  Scenario Outline: Verify that insert videos by clicking on the video icon and entering the <VideoSource> video URL.
  When User clicks Appreciation subheading from More tabb
  And User clicks insert video iconn
  And User enterss "<VideoURL>"
  And User click Save buttonn
  Then User should be able to see inserted videoo "<VideoURL>"
  Examples:
  | VideoSource | VideoURL                                    |
  | Youtube     | https://www.youtube.com/watch?v=k-7jJP7QFEM |
  | Vimeo       | https://vimeo.com/26                        |




        #TC01
  @REM-1039
  @run
  Scenario Outline: Verify that <FileTypeOrSize> file from local disks should be uploaded
  When     User clicks Appreciation subheading from More tabb
  And      User click Upload files and images after clicking upload file iconn
  And      User upload "<FileName>" filee
  Then     System display the uploaded "<FileName>" file under the Attached files and images sectionn

  Examples:
  | FileTypeOrSize | FileName         |
  | txt            | test2.txt        |
  | mp3            | sample2.mp3      |
  | mp4            | sample2.mp4      |
  | 0 byte         | 0_ByteFile2      |
  | 100 Mb         | 100MbFile2.exe   |
  | No_extension   | NoExtensionFile2 |

