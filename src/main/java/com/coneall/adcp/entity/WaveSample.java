package com.coneall.adcp.entity;

import lombok.Data;

import java.util.List;

@Data
public class WaveSample {
    public boolean IsVerticalSample;
    public float[] VertBeam;
    public float VertBeamHeight;
    public float Pressure;
    public float VertPressure;
    public float WaterTemp;
    public float Heading;
    public float Pitch;
    public float Roll;
    public float[][] BeamVel;
    public double TimeStampSeconds;
    public double sampleTime;
    public float[] RangeTracking;
    public float VertRangeTracking;
    public float Height;
    public int NumSamples;
    public int EnsembleNumber;
    public List<Integer> SelectedBins;
    public float[] EastTransformData;
    public float[] NorthTransformData;
    public float[] VerticalTransformData;
    public float[] wavesCellDepth;
    public WaveSample(int numBeams, List<Integer> selectedBins) {
        Init(numBeams, selectedBins.size());
    }
    public void WavesSample(int beams, List<Integer> SelectedBins) {
        Init(beams, SelectedBins.size());
    }
    public void WavesSample(int beams, int SelectedBinCount) {
        Init(beams, SelectedBinCount);
    }
    public void Init(int beams, int bins) {
        if (beams == 1) {
            IsVerticalSample = true;
        } else {
            IsVerticalSample = false;
        }
        VertBeam = new float[bins];
        VertBeamHeight = 0.0f;
        Pressure = 0.0f;
        VertPressure = 0.0f;
        WaterTemp = 0.0f;
        Heading = 0.0f;
        Pitch = 0.0f;
        Roll = 0.0f;
        BeamVel = new float[bins][beams];
        TimeStampSeconds = 0.0;
        //SampleTime = 0.0;
        RangeTracking = new float[beams];
        VertRangeTracking = 0.0f;
        Height = 0;
        NumSamples = 0;
        EnsembleNumber = 0;
        EastTransformData = new float[bins];
        NorthTransformData = new float[bins];
        VerticalTransformData = new float[bins];
    }
}
