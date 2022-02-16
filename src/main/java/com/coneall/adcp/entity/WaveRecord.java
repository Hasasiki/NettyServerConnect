package com.coneall.adcp.entity;

import java.util.ArrayList;
import java.util.List;

public class WaveRecord {
    public List<WaveSample> WaveSamples;
    public boolean IsFirstSampleSet;
    public float HeightSrc;
    public double FirstSampleTime;
    public String DateStr;
    public String SnStr;
    public double Latitude;
    public double Longitude;
    public float[] WaveCellDepth;
    public float PressureSensorHeight;
    public List<Integer> SelectedBins;
    public String InfoTxt;
    public float TimeBetweenSamples = 0.4f;
    public static float HeightSource_Vertical;
    public int RecordNumber;
    public void WavesRecord() {
        Init();
    }
    public void Init() {
        WaveSamples = new ArrayList<WaveSample>();
        HeightSrc = HeightSource_Vertical;
        SnStr = "";
        FirstSampleTime = 0.0;
        Latitude = 0.0;
        Longitude = 0.0;
        PressureSensorHeight = 0.65f;
        SelectedBins = new ArrayList<Integer>();
        // By default there are 3 selected bins
        WaveCellDepth = new float[3];
        DateStr = "";
        InfoTxt = "";
        TimeBetweenSamples = 0.0f;
        RecordNumber = 0;
        IsFirstSampleSet = false;
    }
}
