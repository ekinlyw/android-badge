Android-badge
===============
BadgeUtil provides static utility methods to set "badge count" on Launcher (by Samsung, LG).

Screenshots
===============
Captured from Samsung Galaxy S3

![Captured from Samsung Galaxy S3](https://dl.dropboxusercontent.com/u/16783438/github/Badge/badge-s3.png)

Captured from Samsung Galaxy S4

![Captured from Samsung Galaxy S4](https://dl.dropboxusercontent.com/u/16783438/github/Badge/badge-s4.png)

Captured from LG G3

![Captured from LG G3](https://dl.dropboxusercontent.com/u/16783438/github/Badge/badge-g3.png)


API Usage
===============
	BadgeUtil.setBadgeCount(Context, count);

    BadgeUtil.resetBadgeCount(Context);
Limitation
===============
Currently, it's working from Android 4.0.
But some devices, which are released from the manufacturers, are not working.

You should reset badge count at first launch because the old  count could be saved even after uninstall application.

License
===============
MIT License
