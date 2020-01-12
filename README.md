Android-badge
===============
BadgeUtil provides static utility methods to set "badge count" on Launcher (by Samsung, LG).

Screenshots
===============
Captured from Samsung Galaxy S3

![Captured from Samsung Galaxy S3](https://user-images.githubusercontent.com/1778805/72220549-06e08c80-3595-11ea-9e2e-6bd10a6b54d0.png)

Captured from Samsung Galaxy S4

![Captured from Samsung Galaxy S4](https://user-images.githubusercontent.com/1778805/72220550-08aa5000-3595-11ea-8b86-798464dddbf3.png)

Captured from LG G3

![Captured from LG G3](https://user-images.githubusercontent.com/1778805/72220551-09db7d00-3595-11ea-9d9f-ed576dcdf5db.png)


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
