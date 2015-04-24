package com.myproject.mobistore;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class Dbconn  extends SQLiteOpenHelper {
	 
	    // Context : provides access to application-specific resources and classes    
   public Dbconn(Context applicationcontext) {
         
       // Call use the database or to create it
      
      super(applicationcontext, "store.db", null, 1);
      //applicationcontext.deleteDatabase("store.db");
   } 

   public void onCreate(SQLiteDatabase db) {
	   
	   String query1= "CREATE TABLE IF NOT EXISTS `category` (" +
  "`companyname` varchar(10) NOT NULL,"+
  "`image` varchar(50) NOT NULL,"+
  "PRIMARY KEY (`companyname`))";
	   
	   String query2= "INSERT INTO `category` (`companyname`, `image`) VALUES"+
"('Apple', 'company/apple.jpg'),"+
"('blackberry', 'company/blackberry1.jpg'),"+
"('htc', 'company/htc.jpg'),"+
"('lg', 'company/lg.jpg'),"+
"('Micromax', 'company/micromax.png'),"+
"('motorola', 'company/motorola1.jpg'),"+
"('nokia', 'company/nokia.jpg'),"+
"('samsung', 'company/samsung.jpg'),"+
"('sony', 'company/sony.jpg')";
	   
	   String query3="CREATE TABLE IF NOT EXISTS `cart` ("+
  "`username` varchar(20) NOT NULL,"+
  "`phoneid` varchar(20) NOT NULL,"+
  "PRIMARY KEY (`username`,`phoneid`) )";
	   
	   String query4="INSERT INTO `cart` (`username`, `phoneid`) VALUES"+
"('nitish', 'p14')";
 
       String query5="CREATE TABLE IF NOT EXISTS `customers` ("+
  "`customername` varchar(20) NOT NULL,"+
  "`gender` varchar(10) NOT NULL,"+
  "`age` int(5) NOT NULL,"+
  "`address` varchar(100) NOT NULL,"+
  "`mobile` bigint(10) NOT NULL,"+
  "`email` varchar(50) NOT NULL,"+
  "`username` varchar(20) NOT NULL PRIMARY KEY,"+
  "`password` varchar(20) NOT NULL) ";
   
     String query6="INSERT INTO `customers` (`customername`, `gender`, `age`, `address`, `mobile`, `email`, `username`, `password`) VALUES"+
"('nitish', 'male', 19, 'niitshs', 9999000088, 'nitish@gmail.com', 'abcdef', 'abcdefg'),"+
"('arena', 'female', 25, 'civil lines', 7777777777, 'arena.mbd@gmail.com', 'arena12', 'aaaaaa'),"+
"('nitish tandon', 'male', 20200430, 'friend', 8888777766, 'nitish.tandon1@gmail.com', 'nitish', 'abc')";
     
     String query7="CREATE TABLE IF NOT EXISTS `orders` ("+
  "`username` varchar(20) NOT NULL,"+
  "`phoneid` varchar(20) NOT NULL,"+
  "`orderdate` date NOT NULL)";
     
     String query8="INSERT INTO `orders` (`username`, `phoneid`, `orderdate`) VALUES"+
"('nitish', 'p6', '2014-08-01'),"+
"('nitish', 'p6', '2014-08-02'),"+
"('nitish', 'p8', '2014-09-10'),"+
"('nitish', 'p10', '2014-10-04'),"+
"('nitish', 'p11', '2014-08-01'),"+
"('nitish', 'p12', '2014-08-01'),"+
"('nitish', 'p7', '2014-08-01')";
     
     String query9="CREATE TABLE IF NOT EXISTS `product` ("+
  "`Id` varchar(20) NOT NULL,"+
  "`Companyname` varchar(20) NOT NULL,"+
  "`Modelname` varchar(50) NOT NULL,"+
  "`Color` varchar(50) NOT NULL,"+
  "`MRP` int(10) NOT NULL,"+
  "`Discount` varchar(10) NOT NULL,"+
  "`Price` int(10) NOT NULL,"+
  "`Status` varchar(20) NOT NULL,"+
  "`Description` varchar(1000) NOT NULL,"+
  "`Pros` varchar(500) NOT NULL,"+
  "`Cons` varchar(500) NOT NULL,"+
  "`imagesrc` varchar(50) NOT NULL,"+
  "`imagesrc1` varchar(50) NOT NULL,"+
  "`imagesrc2` varchar(50) NOT NULL,"+
  "`imagesrc3` varchar(50) NOT NULL,"+
  "`imagesrc4` varchar(50) NOT NULL,"+
  "`Devicetype` varchar(30) NOT NULL,"+
  "`OS` varchar(30) NOT NULL,"+
  "`Dimensions` varchar(80) NOT NULL,"+
  "`Weight` varchar(20) NOT NULL,"+
  "`Physicalsize` varchar(30) NOT NULL,"+
  "`Resolution` varchar(25) NOT NULL,"+
  "`Pixeldensity` varchar(20) NOT NULL,"+
  "`Technology` varchar(50) NOT NULL,"+
  "`Colors` varchar(30) NOT NULL,"+
  "`Touchscreen` varchar(30) NOT NULL,"+
  "`Displayfeatures` varchar(50) NOT NULL,"+
  "`Camera` varchar(20) NOT NULL,"+
  "`Aperturesize` varchar(10) NOT NULL,"+
  "`Focallength` varchar(10) NOT NULL,"+
  "`Camerasensorsize` varchar(10) NOT NULL,"+
  "`Camerafeatures` varchar(500) NOT NULL,"+
  "`Camcorder` varchar(200) NOT NULL,"+
  "`Camcorderfeatures` varchar(100) NOT NULL,"+
  "`Systemchip` varchar(50) NOT NULL,"+
  "`Processor` varchar(50) NOT NULL,"+
  "`Graphicsprocessor` varchar(20) NOT NULL,"+
  "`Systemmemory` varchar(20) NOT NULL,"+
  "`Built-instorage` varchar(10) NOT NULL,"+
  "`Storageexpansion` varchar(50) NOT NULL,"+
  "`Talktime` varchar(20) NOT NULL,"+
  "`Stand-bytime` varchar(30) NOT NULL,"+
  "`Talktime(3G)` varchar(20) NOT NULL,"+
  "`Capacity` varchar(20) NOT NULL,"+
  "`Filterby` varchar(100) NOT NULL,"+
  "`Musicplayerfeatures` varchar(100) NOT NULL,"+
  "`Radio` varchar(20) NOT NULL,"+
  "`Speakers` varchar(50) NOT NULL,"+
  "`GSM` varchar(50) NOT NULL,"+
  "`UMTS` varchar(100) NOT NULL,"+
  "`Data` varchar(200) NOT NULL,"+
  "`MicroSIM` varchar(10) NOT NULL,"+
  "`Positioning` varchar(50) NOT NULL,"+
  "`Navigation` varchar(80) NOT NULL,"+
  "`Bluetooth` varchar(10) NOT NULL,"+
  "`Wi-Fi` varchar(100) NOT NULL,"+
  "`Mobilehotspot` varchar(10) NOT NULL,"+
  "`USB` varchar(20) NOT NULL,"+
  "`Connector` varchar(20) NOT NULL,"+
  "`USBfeatures` varchar(50) NOT NULL,"+
  "`Notifications` varchar(500) NOT NULL,"+
  "`Additionalmicrophone/s` varchar(100) NOT NULL,"+
  "`Sensors` varchar(100) NOT NULL,"+
  "`Extras` varchar(100) NOT NULL,"+
  "`Screensize` float NOT NULL,"+
  "PRIMARY KEY (`Id`))";
     
     String query10="INSERT INTO `product` (`Id`, `Companyname`, `Modelname`, `Color`, `MRP`, `Discount`, `Price`, `Status`, `Description`, `Pros`, `Cons`, `imagesrc`, `imagesrc1`, `imagesrc2`, `imagesrc3`, `imagesrc4`, `Devicetype`, `OS`, `Dimensions`, `Weight`, `Physicalsize`, `Resolution`, `Pixeldensity`, `Technology`, `Colors`, `Touchscreen`, `Displayfeatures`, `Camera`, `Aperturesize`, `Focallength`, `Camerasensorsize`, `Camerafeatures`, `Camcorder`, `Camcorderfeatures`, `Systemchip`, `Processor`, `Graphicsprocessor`, `Systemmemory`, `Built-instorage`, `Storageexpansion`, `Talktime`, `Stand-bytime`, `Talktime(3G)`, `Capacity`, `Filterby`, `Musicplayerfeatures`, `Radio`, `Speakers`, `GSM`, `UMTS`, `Data`, `MicroSIM`, `Positioning`, `Navigation`, `Bluetooth`, `Wi-Fi`, `Mobilehotspot`, `USB`, `Connector`, `USBfeatures`, `Notifications`, `Additionalmicrophone/s`, `Sensors`, `Extras`, `Screensize`) VALUES"+
"('p1', 'htc', 'Nokia Lumia 630', 'Black, White,Orange,Green,Yellow', 8999, '10%', 7099, 'In Stock', 'The Nokia Lumia 630 sports a 4.5-inch FWVGA display, 1.2 GHz processor, 512MB of RAM and 5-megapixels rear-facing camera without flash. The handset runs Windows Phone 8.1 and has dual SIM variant.', 'Quad core processor,\r\nFast mobile data support (4G)', 'Low pixel density screen (218 ppi),\r\nThe camera lacks flash,\r\nLacks an ambient light sensor for automatic screen brightness adjustment,\r\nNo front-facing camera', 'image/mobilephones/nokia/Nokia-Lumia-630.jpg', 'image/mobilephones/nokia/Nokia-Lumia-630-1.jpg', 'image/mobilephones/nokia/Nokia-Lumia-630-2.jpg', 'image/mobilephones/nokia/Nokia-Lumia-630-3.jpg', 'image/mobilephones/nokia/Nokia-Lumia-630-4.jpg', 'Smart phone', 'Windows Phone 8.1', '5.10 x 2.63 x 0.36 inches (129.5 x 66.7 x 9.2 mm)', '4.73 oz (134 g)', '4.5 inches', '480 x 854 pixels', '218 ppi', 'IPS LCD', '16 777 216', 'Multi-touch', 'Proximity sensor, Scratch-resistant glass', '5 megapixels', 'F2.4', '28 mm', '1/4in', 'Autofocus, Touch to focus, ISO control, White balance presets, Digital zoom, Geo tagging, Panorama, Night mode, Scenes', '1280x720 (720p HD) (30 fps)', 'Continuous autofocus, Video sharing', 'Qualcomm Snapdragon 400', 'Quad core, 1200 MHz, ARM Cortex-A7', 'Adreno 305', '512 MB RAM', '8 GB', 'microSD, microSDHC, microSDXC up to 128 GB', '16.40 hours', '25.0 days (600 hours)', '13.10 hours', '1830 mAh', 'Album', 'Preset equalizer', 'FM', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '900, 2100 MHz', 'HSDPA+ (4G) 21.1 Mbit/s, HSUPA 5.76 Mbit/s, EDGE, GPRS\r\n', 'Yes', 'A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation, Voice navigation, Points of interest (POI)\r\n', '4.0', '802.11 b, g, n', 'Yes', 'USB 2.0', 'microUSB', 'Mass storage device, USB charging', 'Music ringtones (MP3, WAV), Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'Yes', 'Accelerometer', 'Voice dialing, Voice commands, Voice recording', 0),"+
"('p10', 'Samsung', 'Galaxy S5', 'White,Black', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 5),"+
"('p11', 'Samsung', 'Galaxy Note 3', 'White,Black,Golden', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.8 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 4.8),"+
"('p12', 'Samsung', 'Galaxy S4 Active', 'White,Black', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 0),"+
"('p13', 'Samsung', 'Galaxy S4', 'White,Black', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 0),"+
"('p14', 'Micromax', 'Canvas XL', 'White,Black,Golden', 20999, '0', 19999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 0),"+
"('p15', 'Micromax', 'Canvas Elanza 2', 'Black', 18999, '0', 16999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in','Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 0),"+
"('p2', 'htc', 'abx', 'jfasdf', 10000, '1000', 9000, 'in stock', '', '', '', 'image/mobilephones/htc/htc2.png', '', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 0),"+
"('p3', 'htc', 'dsjkdsj', 'fdkjsldsajf', 10000, '20', 9999, 'in stock', '', '', '', 'image/mobilephones/htc/htc3.png', '', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 0),"+
"('p4', 'Apple', 'iPhone 5s', 'White,Black,Golden', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in','Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 4),"+
"('p5', 'Apple', 'iPhone 5c', 'Green,Blue,Yellow,White,Pink', 41000, '0', 39999, 'In Stock', 'The iPhone 5c replaces the iPhone 5 in the Apple stable, inheriting its internals, like the A6 processor, 4inch screen and 8 MP camera, but wraps them up in unapologetically plastic, candy chassis that can be mixed and matched in many colors with the new slotted cases. It is Apple''s first take at the upper mid-range concept, and runs the newest iOS 7 without a hitch.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.90 x 2.33 x 0.35 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5c-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5c-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5c-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5c-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5c-4.jpg', 'Smart phone', 'iOS (7.x)', '4.90 x 2.33 x 0.35 inches (124.4 x 59.2 x 8.97 mm)\r\n', '4.66 oz (132 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.4', '', '', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama\r\n', '1920x1080 (1080p HD) (30 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording, Video light', 'Apple A6', 'Dual core, 1300 MHz', 'Yes', '1016 MB RAM', '32 GB', '', '10.00 hours', '10.4 days (250 hours)', '10.00 hours', '1507 mAh', 'Album, Artist, Playlists\r\n', 'Album art cover, Background playback\r\n', 'no', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE Cat3 Downlink 100 Mbit/s, LTE Cat3/4 Uplink 50 Mbit/s, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass\r\n', 'Voice dialing, Voice commands, Voice recording\r\n', 4),"+
"('p6', 'Blackberry', 'Z3', 'Black', 31999, '', 29000, 'In Stock', 'The BlackBerry Z3 is an all-touch handset with a 5-inch 540x960 display, dual-core 1.2GHz CPU, 1.5GB RAM, 5MP rear camera and 1.1MP front camera, 8GB of storage and a generous 2500mAh battery. It runs BlackBerry OS 10.', 'Big display (5.0 inches),\r\nDual core processor,\r\nLots of RAM (1536 MB RAM)', 'Battery is not user replaceable\r\n', 'image\\mobilephones\\blackberry\\BlackBerry-Z3-0.jpg', 'image\\mobilephones\\blackberry\\BlackBerry-Z3-1.jpg', 'image\\mobilephones\\blackberry\\BlackBerry-Z3-2.jpg', 'image\\mobilephones\\blackberry\\BlackBerry-Z3-3.jpg', 'image\\mobilephones\\blackberry\\BlackBerry-Z3-4.jpg', 'Smart phone', 'BlackBerry (10)', '5.51 x 2.87 x 0.36 inches (140 x 72.8 x 9.26 mm)\r\n', '5.78 oz (164 g)', '5.0 inches', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 0),"+
"('p7', 'BlackBerry', 'Z10', 'White,Black,Golden', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 3.5),"+
"('p8', 'Blackberry', 'Curve 9310', 'White,Black', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/apple/Apple-iPhone-5s-0.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in', 'Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 2.7),"+
"('p9', 'Blackberry', 'Porsche P9981', 'Silver', 50999, '0', 49999, 'In Stock', 'The iPhone 5s is not a radical departure in design for Apple, save for one very important feature. No, we don''t mean the new Space Gray and Gold colors. We have in mind the home button that has been on iPhones from day one, is now turned into a fingerprint scanner dubbed Touch ID. It lets you unlock the phone and authorize purchases, safely storing your fingerprints in the A7 processor itself, out of the reach for anyone but a few default iOS 7 apps. This A7 processor debuts on the iPhone 5s as the first 64-bit mobile chipset in use on a commercial device, utilized by the latest flat and minimalistic iOS 7 that has been rewritten to take advantage of the 64-bit system. It sports a dedicated M7 co-processor for always-on motion sensing, too. The iSight camera stayed 8 MP, but is much improved, with larger pixels, wider aperture, and the ability to shoot slow motion videos, not to mention the dual two-tone LED flash on the back that strives for natural skin color representation.', 'High-resolution display (640 x 1136 pixels),\r\nHigh pixel densitiy screen, over 300ppi (326 ppi),\r\nHigh-resolution camera (8 megapixels),\r\nDual core processor,\r\nFast mobile data support (4G),\r\nSmall dimensions (4.87 x 2.31 x 0.30 inches)', 'Lacks microSD slot for storage expansion,\r\nBattery is not user replaceable,\r\nProprietary USB connector - have to use its cable instead of a standard microUSB', 'image/mobilephones/nokia/Nokia-Lumia-630.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-1.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-2.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-3.jpg', 'image/mobilephones/apple/Apple-iPhone-5s-4.jpg', 'Smart phone', 'iOS (7.x)', '4.87 x 2.31 x 0.30 inches (123.8 x 58.6 x 7.6 mm)\r\n', '3.95 oz (112 g)', '4.0 inches', '640 x 1136 pixels', '326 ppi', 'IPS LCD', '16 777 216', 'Yes', 'Light sensor, Proximity sensor, Oleophobic coating', '8 megapixels', 'F2.2', 'Dual LED', '1/3in','Back-illuminated sensor (BSI), Autofocus, Touch to focus, Digital image stabilization, Face detection, Burst mode, Digital zoom, Geo tagging, High Dynamic Range mode (HDR), Panorama', '1920x1080 (1080p HD) (30 fps), 1280x720 (720p HD) (120 fps)\r\n', 'Digital image stabilization, Picture-taking during video recording\r\n', 'Apple A7 with 64-bit architecture', 'Dual core, 1300 MHz', 'PowerVR G6430', '1024 MB RAM', '64 GB', '', '', '10.4 days (250 hours)', '10.00 hours', '1570 mAh', 'Album, Artist', 'Album art cover, Background playback\r\n', '', 'Earpiece, Loudspeaker', '850, 900, 1800, 1900 MHz', '850, 900, 1700/2100, 1900, 2100 MHz\r\n', 'LTE, HSDPA+ (4G) 42.2 Mbit/s, HSUPA 5.76 Mbit/s, UMTS, EDGE, GPRS\r\n', 'nano', 'GPS, A-GPS, Glonass, Cell ID, Wi-Fi positioning', 'Turn-by-turn navigation\r\n', '4.0', '802.11 a, b, g, n, n 5GHz\r\n', 'Yes', 'Yes', 'Proprietary', 'USB charging', 'Music ringtones (MP3), Polyphonic ringtones, Vibration, Flight mode, Silent mode, Speakerphone\r\n', 'for Noise cancellation, Video recording\r\n', 'Accelerometer, Gyroscope, Compass, Fingerprint ID\r\n', 'Voice dialing, Voice commands, Voice recording', 3)";

     db.execSQL(query1);
     db.execSQL(query2);
     db.execSQL(query3);
     db.execSQL(query4);
     db.execSQL(query5);
     db.execSQL(query6);
     db.execSQL(query7);
     db.execSQL(query8);
     db.execSQL(query9);
     db.execSQL(query10);
     
}
   
   public void replacedb(JSONObject j)
   {
	   SQLiteDatabase db=this.getWritableDatabase();
	   
	   try {
		   
		   db.beginTransaction();
		JSONArray a1=j.getJSONArray("cart");
		JSONArray a2=j.getJSONArray("category");
		JSONArray a3=j.getJSONArray("customers");
		JSONArray a4=j.getJSONArray("orders");
		//JSONArray a5=j.getJSONArray("product");
		
		
		db.execSQL("Delete from cart");
		db.execSQL("Delete from category");
		db.execSQL("Delete from customers");
		db.execSQL("Delete from orders");
		//db.execSQL("Delete from product");
		
		
		
		for(int i=0;i<a1.length();i++)
		{
			JSONObject jo=a1.getJSONObject(i);
			ContentValues values = new ContentValues();	
			values.put("username", jo.getString("username"));
			values.put("phoneid", jo.getString("phoneid"));
			db.insert("cart",null,values);
		}
		
		for(int i=0;i<a2.length();i++)
		{
			JSONObject jo=a2.getJSONObject(i);
			ContentValues values = new ContentValues();	
			values.put("companyname", jo.getString("companyname"));
			values.put("image", jo.getString("image"));
			db.insert("category",null,values);
		}
		
		for(int i=0;i<a3.length();i++)
		{
			JSONObject jo=a3.getJSONObject(i);
			ContentValues values = new ContentValues();	
			values.put("customername", jo.getString("customername"));
			values.put("gender", jo.getString("gender"));
			values.put("age", jo.getString("age"));
			values.put("address", jo.getString("address"));
			values.put("mobile", jo.getString("mobile"));
			values.put("email", jo.getString("email"));
			values.put("username", jo.getString("username"));
			values.put("password", jo.getString("password"));
			db.insert("customers",null,values);
		}
		
		for(int i=0;i<a4.length();i++)
		{
			JSONObject jo=a4.getJSONObject(i);
			ContentValues values = new ContentValues();	
			
		
			values.put("username", jo.getString("username"));
			values.put("phoneid", jo.getString("phoneid"));
			values.put("orderdate", jo.getString("orderdate"));
			
			db.insert("orders",null,values);
		}
	/*	
		for(int i=0;i<a5.length();i++)
		{
			JSONObject jo=a5.getJSONObject(i);
			ContentValues values = new ContentValues();	
			
		
			Iterator<String> keysIterator = jo.keys();
			while (keysIterator.hasNext()) 
			{
			        String keyStr = (String)keysIterator.next();
			        String valueStr = jo.getString(keyStr);
			        values.put(keyStr, valueStr);
			}
			
			db.insert("product",null,values);
		}
	*/	
		
		db.setTransactionSuccessful();
	} catch (JSONException e) {
		e.printStackTrace();
	}
	finally{
	 db.endTransaction();
	}
   db.close();
   }
   
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
	
	public String loginToDB(String u,String p)
	{
		String q="Select * from customers where username='"+u+"' and password='"+p+"'";
		
		SQLiteDatabase db=this.getReadableDatabase();
		
		Cursor c=db.rawQuery(q,null); 
		String res;
		
		if(c.getCount()==0)res="Login Failed";
		
		else
		{
		c.moveToFirst();
		
		res="Welcome "+c.getString(0);
		}
		
		db.close();
		return res;
		
	}
	
	public ArrayList<HashMap<String, String>> getOrders(String us) {
			         
			        // ArrayList that contains every row in the database
			        // and each row key / value stored in a HashMap
			         
			        ArrayList<HashMap<String, String> > orderArrayList;
			         
		        orderArrayList = new ArrayList<HashMap<String, String>>();
			         
			        String selectQuery = "Select  Companyname,Modelname,Id,orderdate from product,orders where product.Id=orders.phoneid and orders.username='"+us+"'";
			         
			        // Open a database for reading and writing
			         
			        SQLiteDatabase database = this.getWritableDatabase();

			         
			        Cursor cursor = database.rawQuery(selectQuery, null);  
			         
		        // Move to the first row
			         
			        if (cursor.moveToFirst()) {
		            do {
		               HashMap<String, String> contactMap = new HashMap<String, String>();
		                 
			           
		                 
		              contactMap.put("Model", cursor.getString(0)+" "+cursor.getString(1));
		           contactMap.put("PID", cursor.getString(2));
		            contactMap.put("DOP",cursor.getString(3));   
			                 
			                orderArrayList.add(contactMap);
			            } while (cursor.moveToNext()); // Move Cursor to the next row
			        }
			      database.close();
			        // return contact list
			        return orderArrayList;
			    }
	
	
	
	public ArrayList<HashMap<String, String>> getBrand(String us) {
        
        // ArrayList that contains every row in the database
        // and each row key / value stored in a HashMap
         
        ArrayList<HashMap<String, String> > BList;
         
        BList = new ArrayList<HashMap<String, String>>();
         
        String selectQuery = "Select  Companyname,Modelname,Id from product where product.Companyname='"+us+"'";
         
        // Open a database for reading and writing
         
        SQLiteDatabase database = this.getWritableDatabase();

         
        Cursor cursor = database.rawQuery(selectQuery, null);  
         
    // Move to the first row
         
        if (cursor.moveToFirst()) {
        do {
           HashMap<String, String> contactMap = new HashMap<String, String>();
             
           
             
          contactMap.put("Model", cursor.getString(0)+" "+cursor.getString(1));
       contactMap.put("PID", cursor.getString(2));
        
                 
                BList.add(contactMap);
            } while (cursor.moveToNext()); // Move Cursor to the next row
        }
      database.close();
        // return contact list
        return BList;
    }
	
	public ArrayList<HashMap<String,String> > getCart(String us) {
        
        // ArrayList that contains every row in the database
        // and each row key / value stored in a HashMap
         
        ArrayList<HashMap<String,String> > cartList;
         
    cartList = new ArrayList<HashMap<String,String> >();
         
        String selectQuery = "Select  Companyname,Modelname,Id from product,cart where product.Id=cart.phoneid and cart.username='"+us+"'";
         
        // Open a database for reading and writing
         
        SQLiteDatabase database = this.getWritableDatabase();

         
        Cursor cursor = database.rawQuery(selectQuery, null);  
         
    // Move to the first row
         
        if (cursor.moveToFirst()) {
        do {
           HashMap<String, String> cMap = new HashMap<String, String>();
             
           
             
          cMap.put("Model", cursor.getString(0)+" "+cursor.getString(1));
       cMap.put("PID", cursor.getString(2));
           
                 
                cartList.add(cMap);
            } while (cursor.moveToNext()); // Move Cursor to the next row
        }
      
        database.close();
        // return contact list
        return cartList;
    }
	
	public HashMap<String,String> phoneDetails(String pid)
	{
		HashMap<String,String> h=new HashMap<String,String>();
		String query="select * from product where Id='"+pid+"'";
		
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor c=db.rawQuery(query,null);
		
		if(c.moveToFirst())
		{
			h.put("PID", c.getString(0));
			h.put("Companyname",c.getString(1)); 
		    h.put("Modelname",c.getString(2)); 
		    h.put("Color",c.getString(3));  
		    h.put("MRP",c.getString(4));  
		    h.put("Discount",c.getString(5)); 
		    h.put("Price",c.getString(6));  
		    h.put("Status",c.getString(7)); 
		    h.put("Description",c.getString(8)); 
		    h.put("Pros",c.getString(9));  
		    h.put("Cons",c.getString(10)); 
		    h.put("Devicetype",c.getString(16));  
		    h.put("OS",c.getString(17));  
		    h.put("Weight",c.getString(18));  
		    h.put("Physicalsize",c.getString(19)); 
		    h.put("Resolution",c.getString(20));  
		    h.put("Pixeldensity",c.getString(21)); 
		    h.put("Technology",c.getString(22));  
		    h.put("Colors",c.getString(23));  
		    h.put("Touchscreen",c.getString(24));  
		    h.put("Displayfeatures",c.getString(25));  
		    h.put("Camera",c.getString(26));  
		    h.put("Aperturesize",c.getString(27));  
		    h.put("Focallength",c.getString(28));  
		    h.put("Camerasensorsize",c.getString(29));  
		    h.put("Camerafeatures",c.getString(30)); 
		    h.put("Camcorderfeatures",c.getString(31));  
		    h.put("Systemchip",c.getString(32));  
		    h.put("Processor",c.getString(33));  
		    h.put("Graphicsprocessor",c.getString(34));  
		    h.put("Systemmemory",c.getString(35)); 
		    h.put("Built-instorage",c.getString(36));  
		    h.put("Storageexpansion",c.getString(37));  
		    h.put("Talktime",c.getString(38));  
		    h.put("Stand-bytime",c.getString(39));  
		    h.put("Talktime(3G)",c.getString(40));  
		    h.put("Capacity",c.getString(41));  
		    h.put("Filterby",c.getString(42));  
		    h.put("Musicplayerfeatures",c.getString(43));  
		    h.put("Radio",c.getString(44)); 
		    h.put("Speakers",c.getString(45));  
		    h.put("GSM",c.getString(46));  
		    h.put("UMTS",c.getString(47));  
		    h.put("Data",c.getString(48)); 
		    h.put("MicroSIM",c.getString(49));  
		    h.put("Positioning",c.getString(50));  
		    h.put("Navigation",c.getString(51));  
		    h.put("Bluetooth",c.getString(52));  
		    h.put("Wi-Fi",c.getString(53));  
		    h.put("Mobilehotspot",c.getString(54));  
		    h.put("USB",c.getString(55)); 
		    h.put("Connector",c.getString(56)); 
		    h.put("USBfeatures",c.getString(57));  
		    h.put("Notifications",c.getString(58));  
		    h.put("Additionalmicrophones",c.getString(59));  
		    h.put("Sensors",c.getString(60)); 
		    h.put("Extras",c.getString(61));  
		    h.put("Screensize",c.getString(62));  
		}
		db.close();
		return h;
	}
		

	

	
}
