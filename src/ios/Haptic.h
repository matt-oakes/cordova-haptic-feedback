#import <Cordova/CDVPlugin.h>

@interface Haptic : CDVPlugin

- (void) vibro:(CDVInvokedUrlCommand*)command;

@end