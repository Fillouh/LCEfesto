package com.lcefesto.ops;
import java.lang.Math;
public class Converter {
        public static final String REGEX = "-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?";
        //MEASURE CONSTANTS
        public static final double QUETTA=1000000000000000000000000000000.0;
        public static final double RONNA=1000000000000000000000000000.0;
        public static final double YOTTA=1000000000000000000000000.0;
        public static final double ZETTA=1000000000000000000000.0;
        public static final double EXA=1000000000000000000.0;
        public static final double PETA=1000000000000000.0;
        public static final double TERA=1000000000000.0;
        public static final double GIGA=1000000000;
        public static final double MEGA=1000000;
        public static final double KILO=1000;
        public static final double HECTO=100;
        public static final double DECA=10;
        public static final double DECI=0.1;
        public static final double CENTI=0.01;
        public static final double MILLI=0.001;
        public static final double MICRO=0.000001;
        public static final double NANO=0.000000001;
        public static final double PICO=0.000000000001;
        public static final double FEMTO=0.000000000000001;
        public static final double ATTO=0.000000000000000001;
        public static final double ZEPTO=0.000000000000000000001;
        public static final double YOCTO=0.000000000000000000000001;
        public static final double RONTO=0.000000000000000000000000001;
        public static final double QUECTO=0.000000000000000000000000000001;

        //ACCELERATION CONSTANTS
        public static final double GRAVITY_ACC_MEASURE=0.10197162129779;
        public static final double PLANCK_ACC_MEASURE=1.7985611510791*Math.pow(10.0,-52.0);
        public static final double FOOT_PER_HOUR_PER_SECONDS_MEASURE=1.181102*Math.pow(10.0,4.0);
        public static final double FOOT_PER_MINUTE_PER_SECONDS_MEASURE=196.85039370079;
        public static final double GAL_MEASURE=100;
        public static final double INCH_PER_MINUTE_PER_SECONDS=2362.2049104098;
        public static final double INCH_PER_SECONDS_SQUARED_MEASURE=39.370078740157;
        public static final double KNOT_PER_SECONDS_MEASURE=1.9438446603753;
        public static final double MILE_PER_HOURS_MEASURE=2.237;
        public static final double MILE_PER_MINUTE_PER_SECONDS_MEASURE=0.037282;
        public static final double MILE_PER_SECONDS_SQUARED_MEASURE=0.000621371;

        //ANGOLAR ACCELERATION CONSTANTS
        public static final double RADIANT_SECONDS_SQUARED_MEASURE=0.017453;

        //ANGLE CONSTANTS
        public static final double RADIANT_MEASURE=0.017453;
        public static final double GON_MEASURE=1.111;//grado centesimale
        public static final double MINUTE_OF_ARC_MEASURE=60;
        public static final double SECONDS_OF_ARC_MEASURE=3600;

        //BIT & BYTE CONSTANTS
        public static final double BYTE_MEASURE=0.125;

        //DENSITY CONSTANTS
        public static final double PLANCK_DENSITY_MEASURE=2.0*Math.pow(10.0,-97.0);
        public static final double OUNCE_PER_CUBIC_FOOT_MEASURE=0.9988;
        public static final double OUNCE_PER_CUBIC_INCH_MEASURE=0.00057804;
        public static final double OUNCE_PER_GALLON_MEASURE=0.1335;
        public static final double POUND_PER_CUBIC_FOOT_MEASURE=0.0624;
        public static final double POUND_PER_CUBIC_INCH_MEASURE=3.613 *Math.pow(10.0,-5.0);
        public static final double POUND_PER_GALLON_MEASURE=0.008345;
        public static final double SLUG_PER_CUBIC_FOOT_MEASURE= 0.001940;

        //ENERGY CONSTANTS
        public static final double BRITISH_THERMAL_UNIT_MEASURE=0.00094782;
        public static final double CALORIES_MEASURE=0.238845;
        public static final double ELETTRONVOLT_MEASURE= 6.241506363094*Math.pow(10.0,18.0);
        public static final double PLANCK_ENERGY_MEASURE=5.1124744376278*Math.pow(10.0,-10.0);
        public static final double ERG_MEASURE=Math.pow(10.0,7.0);
        public static final double FOOT_POUND_FORCE_MEASURE=0.737562;
        public static final double FOOT_POUNDAL_MEASURE=23.730360;
        public static final double HARTREE_MEASURE=2.2937126583579*Math.pow(10.0,17.0);
        public static final double HORSEPOWER_PER_HOUR_MEASURE=3.7243947858473*Math.pow(10.0,-7.0);
        public static final double INCH_POUND_FORCE_MEASURE=8.850745;
        public static final double LITRE_ATMOSPHERE_MEASURE=0.000869;
        public static final double QUAD_MEASURE=9.4781712031332*Math.pow(10.0,-19.0);
        public static final double RYDBERG_MEASURE=4.5874253167158*Math.pow(10.0,17.0);
        public static final double THERM_MEASURE=9.4781712031332*Math.pow(10.0,-9.0);
        public static final double WATT_HOUR_MEASURE=0.000277777;

        //MOLAR ENERGY CONSTANTS
        public static final double KILOCAL_MOLE_MEASURE=0.000238845;

        //LUMINOUS FLUX
        public static final double SPHERICAL_CANDLE_POWER_MEASURE=0.079579818;
        public static final double WATT_LED_LAMP_MEASURE=0.005555;
        public static final double WATT_LAMP_POWER=0.1;

        //MAGNETIC FLUX CONSTANTS
        public static final double PLANCK_MAGNETIC_FLOW_MEASURE=1.7785049887065*Math.pow(10.0,16.0);

        //FORCE CONSTANTS
        public static final double NEWTON_MEASURE=9.80665002864;
        public static final double KILOGRAM_FORCE_MEASURE=0.101972;
        public static final double ATOMIC_UNIT_OF_FORCE_MEASURE=1.21378*Math.pow(10.0,7.0);
        public static final double DYN_MEASURE=100000;
        public static final double PLANCK_FORCE_MEASURE=8.264*Math.pow(10.0,-45.0);
        public static final double OUNCE_FORCE_MEASURE=3.596943;
        public static final double POUND_FORCE_MEASURE=0.224808;
        public static final double POUNDAL_MEASURE=7.233013;
        public static final double STHENE_MEASURE=0.001;
        public static final double TON_FORCE_MEASURE=0.000112404;

        //FREQUENCE CONSTANTS
        public static final double PLANCK_FREQUENCE_MEASURE=3.3874203875758*Math.pow(10.0,-43.0);

        //ILLUMINANCE CONSTANTS
        public static final double FOOT_CANDLE_MEASURE=0.092903;
        public static final double NOX_MEASURE=1000;
        public static final double PHOT_MEASURE=0.0001;

        //LIGHT INTENSITY
        public static final double BERLINER_LICHTEINHEIT_MEASURE=0.900900;
        public static final double CANDLE_POWER_MEASURE=1.019367;
        public static final double HEFNERKERZE_MEASURE=1.107419;

        //LEVEL CONSTANTS
        public static final double NEPER_MEASURE=0.115129;

        //LENGHT CONSTANTS
        public static final double MILE_MEASURE=0.000621371;
        public static final double YARD_MEASURE=1.09361;
        public static final double FOOT_MEASURE=3.28084;
        public static final double INCH_MEASURE=39.3701;
        public static final double NAUMILE_MEASURE=0.000539957;
        public static final double ANGSTROM_MEASURE=10000000000.0;
        public static final double LIGHT_YEAR_MEASURE=1.057*Math.pow(10.0,-16.0);

        //MASS CONSTANTS
        public static final double LONGTON_MEASURE=0.000984207;
        public static final double SHORTTON_MEASURE=0.00110231;
        public static final double STONE_MEASURE=0.157473;
        public static final double POUND_MEASURE=2.20462;
        public static final double OUNCE_MEASURE=35.274;

        //ANGULAR MOMENT CONSTANTS
        public static final double PLANCK_CONSTANT_MEASURE=1.5091901796422*Math.pow(10.0,33.0);

        //POWER CONSTANTS
        public static final double MECHANICAL_HORSE_POWER_MEASURE=0.001341;
        public static final double BTU_SECOND_MEASURE=0.000947817;
        public static final double CALORIES_SECOND_MEASURE=0.238845;
        public static final double PLANCK_LEISTUNG_POWER_MEASURE=2.7563395810364*Math.pow(10.0,-53.0);

        //PRESSURE CONSTANTS
        public static final double ATMOSPHERE_MEASURE=9.869*Math.pow(10.0,-6.0);
        public static final double BAR_MEASURE=0.00001;
        public static final double POUND_PER_SQUARED_FOOT_MEASURE=0.020885;
        public static final double POUND_PER_SQUARED_INCH_MEASURE=0.000145037;
        public static final double TORR_MEASURE= 0.007501;

        //SURFACE CONSTANTS
        public static final double ACRE_MEASURE=0.000247105;
        public static final double CIRCULAR_INCH_MEASURE=1973.525;
        public static final double SQUARED_FOOT_MEASURE=10.763910;
        public static final double SQUARED_INCH_MEASURE=1550;

        //TEMPERATURE CONSTANTS
        public static final double KELVIN_MEASURE=273.15;
        public static final double FAHRENHEIT_MEASURE=32;
        public static final double RANKINE_MEASURE=491.67;

        //TIME CONSTANTS
        public static final double MINUTE_MEASURE=60;
        public static final double HOUR_MEASURE=3600;
        public static final double DAY_MEASURE=86400;
        public static final double WEEK_MEASURE=604800;
        public static final double MONTH_MEASURE=2.628e+6;
        public static final double YEAR_MEASURE=3.154e+7;
        public static final double DECADE_MEASURE=3.154e+8;
        public static final double CENTURY_MEASURE=3.154e+9;

        //SPEED CONSTANTS
        public static final double FEET_PER_SECOND_MEASURE=3.280839;
        public static final double INCH_PER_SECOND_MEASURE= 39.370078;
        public static final double MILE_PER_SECOND_MEASURE=0.000621371;
        public static final double BEAUFORT_MEASURE=1.126840;

        //ANGULAR SPEED CONSTANTS
        public static final double RPM_MEASURE=9.549296;
        public static final double DEGREES_PER_SECOND=57.295;
        public static final double HERTZ_MEASURE=0.159154;

        //VOLUME CONSTANTS
        public static final double ACRE_FOOT_MEASURE=0.000810713;
        public static final double ACRE_INCH_MEASURE=0.009728558;
        public static final double LITRE_MEASURE=1000;
        public static final double IMPERIAL_GALLON_MEASURE=219.969248;
        public static final double CUBIC_FOOT_MEASURE=35.314666;
        public static final double CUBIC_INCH_MEASURE= 6.102374*Math.pow(10.0,4.0);
        public static final double CUBIC_MILE_MEASURE=2.3991275857893*Math.pow(10.0,-10.0);

        //ATTRIBUTES FOR MEASURE
        //double measure;

        //FUNCTION FOR MEASURE CONSTANTS
        public static double MeasureToQuetta(double measure){
            return measure/QUETTA;
        }
        public static double MeasureToRonna(double measure){
            return measure/RONNA;
        }
        public static double MeasureToYotta(double measure){
            return measure/YOTTA;
        }
        public static double MeasureToZetta(double measure){
            return measure/ZETTA;
        }
        public static double MeasureToExa(double measure){
            return measure/EXA;
        }
        public static double MeasureToPeta(double measure){
            return measure/PETA;
        }
        public static double MeasureToTera(double measure){
            return measure/TERA;
        }
        public static double MeasureToGiga(double measure){
            return measure/GIGA;
        }
        public static double MeasureToMega(double measure){
            return measure/MEGA;
        }
        public static double MeasureToKilo(double measure){
            return measure/KILO;
        }
        public static double MeasureToHecto(double measure){
            return measure/HECTO;
        }
        public static double MeasureToDeca(double measure){
            return measure/DECA;
        }
        public static double MeasureToDeci(double measure){
            return measure/DECI;
        }
        public static double MeasureToCenti(double measure){
            return measure/CENTI;
        }
        public static double MeasureToMilli(double measure){
            return measure/MILLI;
        }
        public static double MeasureToMicro(double measure){
            return measure/MICRO;
        }
        public static double MeasureToNano(double measure){
            return measure/NANO;
        }
        public static double MeasureToPico(double measure){
            return measure/PICO;
        }
        public static double MeasureToFemto(double measure){
            return measure/FEMTO;
        }
        public static double MeasureToAtto(double measure){
            return measure/ATTO;
        }
        public static double MeasureToZepto(double measure){
            return measure/ZEPTO;
        }
        public static double MeasureToYocto(double measure){
            return measure/YOCTO;
        }
        public static double MeasureToRonto(double measure){
            return measure/RONTO;
        }
        public static double MeasureToQuecto(double measure){
            return measure/QUECTO;
        }

        //ACCELERATION
        //UNIT OF MEASURE [m/s^2]
        public static double AccMetersToGravityAcc(double measure){
            return measure*GRAVITY_ACC_MEASURE;
        }
        public static double AccMetersToPlanckAcc(double measure){
            return measure * PLANCK_ACC_MEASURE;
        }
        public static double AccMetersToFPHS(double measure){
            return measure*FOOT_PER_HOUR_PER_SECONDS_MEASURE;
        }
        public static double AccMetersToFPMS(double measure){
            return measure*FOOT_PER_MINUTE_PER_SECONDS_MEASURE;
        }
        public static double AccMetersToGal(double measure){
            return measure*GAL_MEASURE;
        }
        public static double AccMetersToIPMS(double measure){
            return measure*INCH_PER_MINUTE_PER_SECONDS;
        }
        public static double AccMetersToIPSS(double measure){
            return measure*INCH_PER_SECONDS_SQUARED_MEASURE;
        }
        public static double AccMetersToKnotSeconds(double measure){
            return measure*KNOT_PER_SECONDS_MEASURE;
        }
        public static double AccMetersToMilePerHour(double measure){
            return measure*MILE_PER_HOURS_MEASURE;
        }
        public static double AccMetersToMPMS(double measure){
            return measure*MILE_PER_MINUTE_PER_SECONDS_MEASURE;
        }
        public static double AccMetersToMPSS(double measure){
            return measure*MILE_PER_SECONDS_SQUARED_MEASURE;
        }
        public static double GravityAccToAccMeters(double measure){
            return measure/GRAVITY_ACC_MEASURE;
        }
        public static double PlanckAccToAccMeters(double measure){
            return measure/PLANCK_ACC_MEASURE;
        }
        public static double FPHSToAccMeters(double measure){
            return measure/FOOT_PER_HOUR_PER_SECONDS_MEASURE;
        }
        public static double FPMSToAccMeters(double measure){
            return measure/FOOT_PER_MINUTE_PER_SECONDS_MEASURE;
        }
        public static double GalToAccMeters(double measure){
            return measure/GAL_MEASURE;
        }
        public static double IPMSToAccMeters(double measure){
            return measure/INCH_PER_MINUTE_PER_SECONDS;
        }
        public static double IPSSToAccMeters(double measure){
            return measure/INCH_PER_SECONDS_SQUARED_MEASURE;
        }
        public static double KnotSecondsToAccMeters(double measure){
            return measure/KNOT_PER_SECONDS_MEASURE;
        }
        public static double MilePerHourToAccMeters(double measure){
            return measure/MILE_PER_HOURS_MEASURE;
        }
        public static double MPMSToAccMeters(double measure){
            return measure/MILE_PER_MINUTE_PER_SECONDS_MEASURE;
        }
        public static double MPSSToAccMeters(double measure){
            return measure/MILE_PER_SECONDS_SQUARED_MEASURE;
        }

        //ANGULAR ACCELERATION
        //UNIT OF MEASURE [Grad/s^2]
        public static double GradSecondSquaredToRadSecondSquared(double measure){
            return measure*RADIANT_SECONDS_SQUARED_MEASURE;
        }
        public static double RadSecondSquaredToGradSecondSquared(double measure){
            return measure/RADIANT_SECONDS_SQUARED_MEASURE;
        }

        //ANGLE
        //UNIT OF MEASURE [Grad°]
        public static double GradToRad(double measure){
            return measure*RADIANT_MEASURE;
        }
        public static double GradtoGon(double measure){
            return measure*GON_MEASURE;
        }
        public static double GradToMinuteOfArc(double measure){
            return measure*MINUTE_OF_ARC_MEASURE;
        }
        public static double GradToSecondOfArc(double measure){
            return measure*SECONDS_OF_ARC_MEASURE;
        }
        public static double RadToGrad(double measure){
            return measure/RADIANT_MEASURE;
        }
        public static double GonToGrad(double measure){
            return measure/GON_MEASURE;
        }
        public static double MinuteOfArcToGrad(double measure){
            return measure/MINUTE_OF_ARC_MEASURE;
        }
        public static double SecondOfArcToGrad(double measure){
            return measure/SECONDS_OF_ARC_MEASURE;
        }

        //BIT & BYTES
        public static double BitToByte(double measure){
            return measure*BYTE_MEASURE;
        }
        public static double ByteToBit(double measure){
            return measure/BYTE_MEASURE;
        }

        //DENSITY
        //UNIT OF MEASURE [kg/m^3]
        public static double KiloCubicMetersToPlanckDensity(double measure){
            return measure*PLANCK_DENSITY_MEASURE;
        }
        public static double KiloCubicMetersToOuncePerCubicFoot(double measure){
            return measure*OUNCE_PER_CUBIC_FOOT_MEASURE;
        }
        public static double KiloCubicMetersToOuncePerCubicInch(double measure){
            return measure*OUNCE_PER_CUBIC_INCH_MEASURE;
        }
        public static double KiloCubicMetersToOuncePerGallon(double measure){
            return measure*OUNCE_PER_GALLON_MEASURE;
        }
        public static double KiloCubicMetersToPoundPerCubicFoot(double measure){
            return measure*POUND_PER_CUBIC_FOOT_MEASURE;
        }
        public static double KiloCubicMetersToPoundPerCubicInch(double measure){
            return measure*POUND_PER_CUBIC_INCH_MEASURE;
        }
        public static double KiloCubicMetersToPoundPerGallon(double measure){
            return measure*POUND_PER_GALLON_MEASURE;
        }
        public static double KiloCubicMetersToSlugPerCubicFoot(double measure){
            return measure*SLUG_PER_CUBIC_FOOT_MEASURE;
        }
        public static double PlanckDensityToKiloCubicMeters(double measure){
            return measure/PLANCK_DENSITY_MEASURE;
        }
        public static double OuncePerCubicFootToKiloCubicMeters(double measure){
            return measure/OUNCE_PER_CUBIC_FOOT_MEASURE;
        }
        public static double OuncePerCubicInchToKiloCubicMeters(double measure){
            return measure/OUNCE_PER_CUBIC_INCH_MEASURE;
        }
        public static double OuncePerGallonToKiloCubicMeters(double measure){
            return measure/OUNCE_PER_GALLON_MEASURE;
        }
        public static double PoundPerCubicFootToKiloCubicMeters(double measure){
            return measure/POUND_PER_CUBIC_FOOT_MEASURE;
        }
        public static double PoundPerCubicInchToKiloCubicMeters(double measure){
            return measure/POUND_PER_CUBIC_INCH_MEASURE;
        }
        public static double PoundPerGallonToKiloCubicMeters(double measure){
            return measure/POUND_PER_GALLON_MEASURE;
        }
        public static double SlugPerCubicFootToKiloCubicMeters(double measure){
            return measure/SLUG_PER_CUBIC_FOOT_MEASURE;
        }

        //ENERGY
        //UNIT OF MEASURE [J]
        public static double JouleToBritishThermalUnit(double measure){
            return measure*BRITISH_THERMAL_UNIT_MEASURE;
        }
        public static double JouleToCalories(double measure){
            return measure*CALORIES_MEASURE;
        }
        public static double JouleToElettronVolt(double measure){
            return measure*ELETTRONVOLT_MEASURE;
        }
        public static double JouleToPlanckEnergy(double measure){
            return measure*PLANCK_ENERGY_MEASURE;
        }
        public static double JouleToErg(double measure){
            return measure*ERG_MEASURE;
        }
        public static double JouleToFootPoundForce(double measure){
            return measure*FOOT_POUND_FORCE_MEASURE;
        }
        public static double JouleToFootPoundal(double measure){
            return measure*FOOT_POUNDAL_MEASURE;
        }
        public static double JouleToHartree(double measure){
            return measure*HARTREE_MEASURE;
        }
        public static double JouleToHorsepowerPerHour(double measure){
            return measure*HORSEPOWER_PER_HOUR_MEASURE;
        }
        public static double JouleToInchPoundForce(double measure){
            return measure*INCH_POUND_FORCE_MEASURE;
        }
        public static double JouleToLitreAtmosphere(double measure){
            return measure*LITRE_ATMOSPHERE_MEASURE;
        }
        public static double JouleToQuad(double measure){
            return measure*QUAD_MEASURE;
        }
        public static double JouleToRydberg(double measure){
            return measure*RYDBERG_MEASURE;
        }
        public static double JouleToTherm(double measure){
            return measure*THERM_MEASURE;
        }
        public static double JouleToWattHour(double measure){
            return measure*WATT_HOUR_MEASURE;
        }
        public static double BritishThermalUnitToJoule(double measure){
            return measure/BRITISH_THERMAL_UNIT_MEASURE;
        }
        public static double CaloriesToJoule(double measure){
            return measure/CALORIES_MEASURE;
        }
        public static double ElettronVoltToJoule(double measure){
            return measure/ELETTRONVOLT_MEASURE;
        }
        public static double PlanckEnergyToJoule(double measure){
            return measure/PLANCK_ENERGY_MEASURE;
        }
        public static double ErgToJoule(double measure){
            return measure/ERG_MEASURE;
        }
        public static double FootPoundForceToJoule(double measure){
            return measure/FOOT_POUND_FORCE_MEASURE;
        }
        public static double FootPoundalToJoule(double measure){
            return measure/FOOT_POUNDAL_MEASURE;
        }
        public static double HartreeToJoule(double measure){
            return measure/HARTREE_MEASURE;
        }
        public static double HorsepowerPerHourToJoule(double measure){
            return measure/HORSEPOWER_PER_HOUR_MEASURE;
        }
        public static double InchPoundForceToJoule(double measure){
            return measure/INCH_POUND_FORCE_MEASURE;
        }
        public static double LitreAtmosphereToJoule(double measure){
            return measure/LITRE_ATMOSPHERE_MEASURE;
        }
        public static double QuadToJoule(double measure){
            return measure/QUAD_MEASURE;
        }
        public static double RydbergToJoule(double measure){
            return measure/RYDBERG_MEASURE;
        }
        public static double WattHourToJoule(double measure){
            return measure/WATT_HOUR_MEASURE;
        }

        //MOLAR ENERGY
        //UNIT OF MEASURE [J/mol]
        public static double JouleMoleToKilocalMole(double measure){
            return measure*KILOCAL_MOLE_MEASURE;
        }
        public static double KilocalMoleToJouleMole(double measure){
            return measure/KILOCAL_MOLE_MEASURE;
        }

        //LUMINOUS FLUX
        //UNIT OF MEASURE [Lumen]
        public static double LumenToSphericalCandlePower(double measure){
            return measure*SPHERICAL_CANDLE_POWER_MEASURE;
        }
        public static double LumenToWattLedLamp(double measure){
            return measure*WATT_LED_LAMP_MEASURE;
        }
        public static double LumenToWattLamp(double measure){
            return measure*WATT_LAMP_POWER;
        }
        public static double SphericalCandlePowerToLumen(double measure){
            return measure/SPHERICAL_CANDLE_POWER_MEASURE;
        }
        public static double WattLedLampToLumen(double measure){
            return measure/WATT_LED_LAMP_MEASURE;
        }
        public static double WattLampToLumen(double measure){
            return measure/WATT_LAMP_POWER;
        }

        //MAGNETIC FLOW
        //UNIT OF MEASURE [Weber]
        public static double WeberToPlanckMagneticFlow(double measure){
            return measure*PLANCK_MAGNETIC_FLOW_MEASURE;
        }
        public static double PlanckMagneticFlowToWeber(double measure){
            return measure/PLANCK_MAGNETIC_FLOW_MEASURE;
        }

        //FORCE
        //UNIT OF MEASURE [N]
        public static double NewtonToKilograms(double measure){
            return measure/NEWTON_MEASURE;
        }
        public static double NewtonToKilogramForce(double measure){
            return measure*KILOGRAM_FORCE_MEASURE;
        }
        public static double NewtonToAtomicUnitOfForce(double measure){
            return measure*ATOMIC_UNIT_OF_FORCE_MEASURE;
        }
        public static double NewtonToDyn(double measure){
            return measure*DYN_MEASURE;
        }
        public static double NewtonToPlanckForce(double measure){
            return measure*PLANCK_FORCE_MEASURE;
        }
        public static double NewtonToOunceForce(double measure){
            return measure*OUNCE_FORCE_MEASURE;
        }
        public static double NewtonToPoundForce(double measure){
            return measure*POUND_FORCE_MEASURE;
        }
        public static double NewtonToPoundal(double measure){
            return measure*POUNDAL_MEASURE;
        }
        public static double NewtonToSthene(double measure){
            return measure*STHENE_MEASURE;
        }
        public static double NewtonToTonForce(double measure){
            return measure*TON_FORCE_MEASURE;
        }
        public static double KilogramForceToNewton(double measure){
            return measure/KILOGRAM_FORCE_MEASURE;
        }
        public static double AtomicUnitOfForceToNewton(double measure){
            return measure/ATOMIC_UNIT_OF_FORCE_MEASURE;
        }
        public static double DynToNewton(double measure){
            return measure/DYN_MEASURE;
        }
        public static double PlanckForceToNewton(double measure){
            return measure/PLANCK_FORCE_MEASURE;
        }
        public static double OunceForceToNewton(double measure){
            return measure/OUNCE_FORCE_MEASURE;
        }
        public static double PoundForceToNewton(double measure){
            return measure/POUND_FORCE_MEASURE;
        }
        public static double PoundalToNewton(double measure){
            return measure/POUNDAL_MEASURE;
        }
        public static double StheneToNewton(double measure){
            return measure/STHENE_MEASURE;
        }
        public static double TonForceToNewton(double measure){
            return measure/TON_FORCE_MEASURE;
        }

        //FREQUENCE
        //UNIT OF MEASURE [Hz]
        public static double HertzToSeconds(double measure){
            return 1.0/measure;
        }
        public static double HertzToRPM(double measure){
            return measure*MINUTE_MEASURE;
        }
        public static double HertzToPlanckFrequence(double measure){
            return measure*PLANCK_FREQUENCE_MEASURE;
        }
        public static double PlanckFrequenceToHertz(double measure){
            return measure/PLANCK_FREQUENCE_MEASURE;
        }
        public static double SecondsToHertz(double measure){
            return 1.0/measure;
        }
        public static double RPMToHertz(double measure){
            return measure/MINUTE_MEASURE;
        }

        //ILLUMINANCE
        //UNIT OF MEASURE [Lux]
        public static double LuxToFootCandle(double measure){
            return measure*FOOT_CANDLE_MEASURE;
        }
        public static double LuxToNox(double measure){
            return measure*NOX_MEASURE;
        }
        public static double LuxToPhot(double measure){
            return measure*PHOT_MEASURE;
        }
        public static double FootCandleToLux(double measure){
            return measure/FOOT_CANDLE_MEASURE;
        }
        public static double NoxToLux(double measure){
            return measure/NOX_MEASURE;
        }
        public static double PhotToLux(double measure){
            return measure/PHOT_MEASURE;
        }

        //LIGHT INTENSITY
        //UNIT OF MEASURE [Cd]
        public static double CandleToBerlinerLichteinheit(double measure){
            return measure*BERLINER_LICHTEINHEIT_MEASURE;
        }
        public static double CandleToCandlePower(double measure){
            return measure*CANDLE_POWER_MEASURE;
        }
        public static double CandleToHefnerkerze(double measure){
            return measure*HEFNERKERZE_MEASURE;
        }
        public static double BerlinerLichteinheitToCandle(double measure){
            return measure/BERLINER_LICHTEINHEIT_MEASURE;
        }
        public static double CandlePowerToCandle(double measure){
            return measure/CANDLE_POWER_MEASURE;
        }
        public static double HefnerkerzeToCandle(double measure){
            return measure/HEFNERKERZE_MEASURE;
        }

        //LEVEL
        //UNIT OF MEASURE [db]
        public static double DecibelToNeper(double measure){
            return measure*NEPER_MEASURE;
        }
        public static double NeperToDecibel(double measure){
            return measure/NEPER_MEASURE;
        }

        //LENGHT:
        //UNIT OF MEASURE : meters [m]
        public static double MetersToMile(double measure){
            return measure*MILE_MEASURE;
        }
        public static double MetersToYard(double measure){
            return measure*YARD_MEASURE;
        }
        public static double MetersToFoot(double measure){
            return measure*FOOT_MEASURE;
        }
        public static double MetersToInch(double measure){
            return measure*INCH_MEASURE;
        }
        public static double MetersToNauticalMile(double measure){
            return measure*NAUMILE_MEASURE;
        }
        public static double MetersToAngstrom(double measure){
            return measure*ANGSTROM_MEASURE;
        }
        public static double MetersToLightYear(double measure){
            return measure*LIGHT_YEAR_MEASURE;
        }
        public static double MileToMeters(double measure){
            return measure/MILE_MEASURE;
        }
        public static double YardToMeters(double measure){
            return measure/YARD_MEASURE;
        }
        public static double FootToMeters(double measure){
            return measure/FOOT_MEASURE;
        }
        public static double InchToMeters(double measure){
            return measure/INCH_MEASURE;
        }
        public static double NauticalMileToMeters(double measure){
            return measure*NAUMILE_MEASURE;
        }
        public static double AngstromToMeters(double measure){
            return measure/ANGSTROM_MEASURE;
        }
        public static double LightYearToMeters(double measure){
            return measure/LIGHT_YEAR_MEASURE;
        }

        //MASS
        //UNIT OF MEASURE : [kg]
        public static double KilogramToMetricTon(double measure){
            return measure/KILO;
        }
        public static double KilogramToLongTon(double measure){
            return measure*LONGTON_MEASURE;
        }
        public static double KilogramToShortTon(double measure){
            return measure*SHORTTON_MEASURE;
        }
        public static double KilogramToStone(double measure){
            return measure*STONE_MEASURE;
        }
        public static double KilogramToPound(double measure){
            return measure*POUND_MEASURE;
        }
        public static double KilogramToOunce(double measure){
            return measure*OUNCE_MEASURE;
        }
        public static double KilogramToNewton(double measure){
            return measure*NEWTON_MEASURE;
        }
        public static double MetricTonToKilogram(double measure){
            return measure*KILO;
        }
        public static double LongTonToKilogram(double measure){
            return measure/LONGTON_MEASURE;
        }
        public static double ShortTonToKilogram(double measure){
            return measure/SHORTTON_MEASURE;
        }
        public static double StoneToKilogram(double measure){
            return measure/STONE_MEASURE;
        }
        public static double PoundToKilogram(double measure){
            return measure/POUND_MEASURE;
        }
        public static double OunceToKilogram(double measure){
            return measure/OUNCE_MEASURE;
        }

        //ANGULAR MOMENT
        //UNIT OF MEASURE [(kg*m^2)/s]
        public static double NewtonMetersSecondToPlanckConstant(double measure){
            return measure*PLANCK_CONSTANT_MEASURE;
        }
        public static double PlanckConstantToNewtonMetersSecond(double measure){
            return measure/PLANCK_CONSTANT_MEASURE;
        }

        //PARTS-PER
        //UNIT OF MEASURE [%]
        public static double PercentToPerThousand(double measure){
            return measure*DECA;
        }
        public static double PercentToPartsPerMillion(double measure){
            return measure*DECA*KILO;
        }
        public static double PercentToPartsPerBillion(double measure){
            return measure*DECA*MEGA;
        }
        public static double PerThousandToPercent(double measure){
            return measure/DECA;
        }
        public static double PartsPerMillionToPercent(double measure){
            return measure/(DECA*KILO);
        }
        public static double PartsPerBillionToPercent(double measure){
            return measure/(DECA*MEGA);
        }

        //POWER
        //UNIT OF MEASURE [W]
        public static double WattToMechanicalHorsePower(double measure){
            return measure*MECHANICAL_HORSE_POWER_MEASURE;
        }
        public static double WattToBTUPerMinutes(double measure){
            return measure*BTU_SECOND_MEASURE;
        }
        public static double WattToCaloriesSecond(double measure){
            return measure*CALORIES_SECOND_MEASURE;
        }
        public static double WattToPlanckLeistungPower(double measure){
            return measure*PLANCK_LEISTUNG_POWER_MEASURE;
        }
        public static double MechanicalHorsePowerToWatt(double measure){
            return measure/MECHANICAL_HORSE_POWER_MEASURE;
        }
        public static double BTUPerMinutesToWatt(double measure){
            return measure/BTU_SECOND_MEASURE;
        }
        public static double CaloriesSecondToWatt(double measure){
            return measure/CALORIES_SECOND_MEASURE;
        }
        public static double PlanckLeistungPowerToWatt(double measure){
            return measure/PLANCK_LEISTUNG_POWER_MEASURE;
        }

        //PRESSURE
        //UNIT OF MEASURE [Pascal]
        public static double PascalToAtmosphere(double measure){
            return measure*ATMOSPHERE_MEASURE;
        }
        public static double PascalToBar(double measure){
            return measure*BAR_MEASURE;
        }
        public static double PascalToPoundPerSquaredFoot(double measure){
            return measure*POUND_PER_SQUARED_FOOT_MEASURE;
        }
        public static double PascalToPoundPerSquaredInch(double measure){
            return measure*POUND_PER_SQUARED_INCH_MEASURE;
        }
        public static double PascalToTorr(double measure){
            return measure*TORR_MEASURE;
        }
        public static double AtmosphereToPascal(double measure){
            return measure/ATMOSPHERE_MEASURE;
        }
        public static double BarToPascal(double measure){
            return measure/BAR_MEASURE;
        }
        public static double PoundPerSquaredFootToPascal(double measure){
            return measure/POUND_PER_SQUARED_FOOT_MEASURE;
        }
        public static double PoundPerSquaredInchToPascal(double measure){
            return measure/POUND_PER_SQUARED_INCH_MEASURE;
        }
        public static double TorrToPascal(double measure){
            return measure/TORR_MEASURE;
        }

        //SURFACE
        //UNIT OF MEASURE [m^2]
        public static double SquaredMetersToAcre(double measure){
            return measure*ACRE_MEASURE;
        }
        public static double SquaredMetersToCircularInch(double measure){
            return measure*CIRCULAR_INCH_MEASURE;
        }
        public static double SquaredMetersToSquaredFoot(double measure){
            return measure*SQUARED_FOOT_MEASURE;
        }
        public static double SquaredMetersToSquaredInch(double measure){
            return measure*SQUARED_INCH_MEASURE;
        }
        public static double AcreToSquaredMeters(double measure){
            return measure/ACRE_MEASURE;
        }
        public static double CircularInchToSquaredMeters(double measure){
            return measure/CIRCULAR_INCH_MEASURE;
        }
        public static double SquaredFootToSquaredMeters(double measure){
            return measure/SQUARED_FOOT_MEASURE;
        }
        public static double SquaredInchToSquaredMeters(double measure){
            return measure/SQUARED_INCH_MEASURE;
        }

        //TEMPERATURE
        //UNIT OF MEASURE [°C]
        public static double CelsiusToKelvin(double measure){
            return measure+KELVIN_MEASURE;
        }
        public static double CelsiusToFahrenheit(double measure){
            return measure+FAHRENHEIT_MEASURE;
        }
        public static double CelsiusToRankine(double measure){
            return measure+RANKINE_MEASURE;
        }
        public static double KelvinToCelsius(double measure){
            return measure-KELVIN_MEASURE;
        }
        public static double FahrenheitToCelsius(double measure){
            return measure-FAHRENHEIT_MEASURE;
        }
        public static double RankineToCelsius(double measure){
            return measure-RANKINE_MEASURE;
        }

        //TIME
        //UNIT OF MEASURE [s]
        public static double SecondsToMinutes(double measure){
            return measure/MINUTE_MEASURE;
        }
        public static double SecondsToHours(double measure){
            return measure/HOUR_MEASURE;
        }
        public static double SecondsToDays(double measure){
            return measure/DAY_MEASURE;
        }
        public static double SecondsToWeeks(double measure){
            return measure/WEEK_MEASURE;
        }
        public static double SecondsToMonths(double measure){
            return measure/MONTH_MEASURE;
        }
        public static double SecondsToYears(double measure){
            return measure/YEAR_MEASURE;
        }
        public static double SecondsToDecades(double measure){
            return measure/DECADE_MEASURE;
        }
        public static double SecondsToCenturies(double measure){
            return measure/CENTURY_MEASURE;
        }
        public static double MinutesToSeconds(double measure){
            return measure*MINUTE_MEASURE;
        }
        public static double HoursToSeconds(double measure){
            return measure*HOUR_MEASURE;
        }
        public static double DaysToSeconds(double measure){
            return measure*DAY_MEASURE;
        }
        public static double WeekToSeconds(double measure){
            return measure*WEEK_MEASURE;
        }
        public static double MonthsToSeconds(double measure){
            return measure*MONTH_MEASURE;
        }
        public static double YearsToSeconds(double measure){
            return measure*YEAR_MEASURE;
        }
        public static double DecadesToSeconds(double measure){
            return measure*DECADE_MEASURE;
        }
        public static double CenturiesToSeconds(double measure){
            return measure*CENTURY_MEASURE;
        }

        //SPEED
        //UNIT OF MEASURE [m/s]
        public static double MetersPerSecondToFeetPerSecond(double measure){
            return measure*FEET_PER_SECOND_MEASURE;
        }
        public static double MetersPerSecondToInchPerSecond(double measure){
            return measure*INCH_PER_SECOND_MEASURE;
        }
        public static double MetersPerSecondToMilePerSecond(double measure){
            return measure*MILE_PER_SECOND_MEASURE;
        }
        public static double MetersPerSecondToBeaufort(double measure){
            return measure*BEAUFORT_MEASURE;
        }
        public static double FeetPerSecondToMetersPerSecond(double measure){
            return measure/FEET_PER_SECOND_MEASURE;
        }
        public static double InchPerSecondToMetersPerSecond(double measure){
            return measure/INCH_PER_SECOND_MEASURE;
        }
        public static double MilePerSecondToMetersPerSecond(double measure){
            return measure/MILE_PER_SECOND_MEASURE;
        }
        public static double BeaufortToMetersPerSecond(double measure){
            return measure/BEAUFORT_MEASURE;
        }

        //ANGULAR SPEED
        //UNIT OF MEASURE [rad/s]
        public static double RadiansPerSecondToRPM(double measure){
            return measure*RPM_MEASURE;
        }
        public static double RadiansPerSecondToDegreesPerSecond(double measure){
            return measure*DEGREES_PER_SECOND;
        }
        public static double RadiansPerSecondToHertz(double measure){
            return measure*HERTZ_MEASURE;
        }
        public static double RPMToRadiansPerSecond(double measure){
            return measure/RPM_MEASURE;
        }
        public static double DegreesPerSecondToRadiansPerSecond(double measure){
            return measure/DEGREES_PER_SECOND;
        }
        public static double HertzToRadiansPerSecond(double measure){
            return measure/HERTZ_MEASURE;
        }

        //VOLUME
        //UNIT OF MEASURE [m^3]
        public static double CubicMetersToAcreFoot(double measure){
            return measure*ACRE_FOOT_MEASURE;
        }
        public static double CubicMetersToAcreInch(double measure){
            return measure*ACRE_INCH_MEASURE;
        }
        public static double CubicMetersToLitre(double measure){
            return measure*LITRE_MEASURE;
        }
        public static double CubicMetersToImperialGallon(double measure){
            return measure*IMPERIAL_GALLON_MEASURE;
        }
        public static double CubicMetersToCubicFoot(double measure){
            return measure*CUBIC_FOOT_MEASURE;
        }
        public static double CubicMetersToCubicInch(double measure){
            return measure*CUBIC_INCH_MEASURE;
        }
        public static double CubicMetersToCubicMile(double measure){
            return measure*CUBIC_MILE_MEASURE;
        }
        public static double AcreFootToCubicMeters(double measure){
            return measure/ACRE_FOOT_MEASURE;
        }
        public static double AcreInchToCubicMeters(double measure){
            return measure/ACRE_INCH_MEASURE;
        }
        public static double LitreToCubicMeters(double measure){
            return measure/LITRE_MEASURE;
        }
        public static double ImperialGallonToCubicMeters(double measure){
            return measure/IMPERIAL_GALLON_MEASURE;
        }
        public static double CubicFootToCubicMeters(double measure){
            return measure/CUBIC_FOOT_MEASURE;
        }
        public static double CubicInchToCubicMeters(double measure){
            return measure/CUBIC_INCH_MEASURE;
        }
        public static double CubicMileToCubicMeters(double measure){
            return measure/CUBIC_MILE_MEASURE;
        }

}
