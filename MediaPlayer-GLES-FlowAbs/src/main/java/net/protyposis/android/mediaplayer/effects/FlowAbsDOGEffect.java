/*
 * Copyright (c) 2014 Mario Guggenberger <mg@protyposis.net>
 *
 * This file is part of MediaPlayer-Extended.
 *
 * MediaPlayer-Extended is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MediaPlayer-Extended is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MediaPlayer-Extended.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.protyposis.android.mediaplayer.effects;

import net.protyposis.android.mediaplayer.gles.Framebuffer;
import net.protyposis.android.mediaplayer.gles.Texture2D;

/**
 * Created by Mario on 18.07.2014.
 */
public class FlowAbsDOGEffect extends FlowAbsSubEffect {

    private int mN;
    private float mSigmaE;
    private float mSigmaR;
    private float mTau;
    private float mPhi;

    FlowAbsDOGEffect() {
        super();
        mN = 1;
        mSigmaE = 1.0f;
        mSigmaR = 1.6f;
        mTau = 0.99f;
        mPhi = 2.0f;

        addParameter(new IntegerParameter("N", 0, 10, mN, new IntegerParameter.Delegate() {
            @Override
            public void setValue(int value) {
                mN = value;
            }
        }));
        addParameter(new FloatParameter("sigmaE", 0f, 10f, mSigmaE, new FloatParameter.Delegate() {
            @Override
            public void setValue(float value) {
                mSigmaE = value;
            }
        }));
        addParameter(new FloatParameter("sigmaR", 0f, 10f, mSigmaR, new FloatParameter.Delegate() {
            @Override
            public void setValue(float value) {
                mSigmaR = value;
            }
        }));
        addParameter(new FloatParameter("tau", 0f, 10f, mTau, new FloatParameter.Delegate() {
            @Override
            public void setValue(float value) {
                mTau = value;
            }
        }));
        addParameter(new FloatParameter("phi", 0f, 10f, mPhi, new FloatParameter.Delegate() {
            @Override
            public void setValue(float value) {
                mPhi = value;
            }
        }));
    }

    @Override
    public void apply(Texture2D source, Framebuffer target) {
        mFlowAbsEffect.mFlowAbs.dog(source, target, mN, mSigmaE, mSigmaR, mTau, mPhi);
    }
}
