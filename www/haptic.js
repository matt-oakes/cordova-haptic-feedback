var Haptic = function() {};

Haptic.prototype.impactLight = function() {
    cordova.exec(function(){}, function(){}, "Haptic","vibro", ['impactLight']);
};

Haptic.prototype.impactMedium = function() {
    cordova.exec(function(){}, function(){}, "Haptic","vibro", ['impactMedium']);
};

Haptic.prototype.impactHeavy = function() {
    cordova.exec(function(){}, function(){}, "Haptic","vibro", ['impactHeavy']);
};

Haptic.prototype.notificationSuccess = function() {
    cordova.exec(function(){}, function(){}, "Haptic","vibro", ['notificationSuccess']);
};

Haptic.prototype.notificationWarning = function() {
    cordova.exec(function(){}, function(){}, "Haptic","vibro", ['notificationWarning']);
};

Haptic.prototype.notificationError = function() {
    cordova.exec(function(){}, function(){}, "Haptic","vibro", ['notificationError']);
};

var Haptic = new Haptic();
module.exports = Haptic;

