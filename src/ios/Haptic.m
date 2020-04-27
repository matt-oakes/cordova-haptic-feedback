#import "Haptic.h"
#import <UIKit/UIKit.h>
#import <sys/utsname.h>
#import "DeviceUtils.h"
#import <AudioToolbox/AudioToolbox.h>
#import <AudioToolbox/AudioServices.h>





@implementation Haptic

- (void) vibro:(CDVInvokedUrlCommand*)command
{

    // get arguments from Javascript
    id type = [command.arguments objectAtIndex:0];
    
    if ([self supportsHaptic]){
       
        if ([type compare: @"impactLight"]) {
            [self generateImpactFeedback:UIImpactFeedbackStyleLight];
        } else if ([type compare:@"impactMedium"]) {
            [self generateImpactFeedback:UIImpactFeedbackStyleMedium];
        } else if ([type compare:@"impactHeavy"]) {
            [self generateImpactFeedback:UIImpactFeedbackStyleHeavy];
        } else if ([type compare:@"notificationSuccess"]) {
            [self generateNotificationFeedback:UINotificationFeedbackTypeSuccess];
        } else if ([type compare:@"notificationWarning"]) {
            [self generateNotificationFeedback:UINotificationFeedbackTypeWarning];
        } else if ([type compare:@"notificationError"]) {
            [self generateNotificationFeedback:UINotificationFeedbackTypeError];
        } else {
            [self generateSelectionFeedback];
        }
        
    } else {
       AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
    }
   
}

-(Boolean)supportsHaptic {
    return [[UIDevice currentDevice] systemVersion].floatValue >= 10.0 && [DeviceUtils deviceVersion:@"iPhone"] > 7;
}


-(void)generateSelectionFeedback{
    UISelectionFeedbackGenerator *generator = [[UISelectionFeedbackGenerator alloc] init];
    [generator prepare];
    [generator selectionChanged];
    generator = nil;
}

-(void)generateImpactFeedback:(UIImpactFeedbackStyle)style{
    UIImpactFeedbackGenerator *generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:style];
    [generator prepare];
    [generator impactOccurred];
    generator = nil;
}

-(void)generateNotificationFeedback:(UINotificationFeedbackType)notificationType{
    UINotificationFeedbackGenerator *generator = [[UINotificationFeedbackGenerator alloc] init];
    [generator prepare];
    [generator notificationOccurred:notificationType];
    generator = nil;
}


@end

