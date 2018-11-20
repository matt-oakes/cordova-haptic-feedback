#import <Foundation/Foundation.h>

@interface DeviceUtils : NSObject

+ (NSString *) platform;
+ (int)deviceVersion:(NSString*)deviceType;

@end;