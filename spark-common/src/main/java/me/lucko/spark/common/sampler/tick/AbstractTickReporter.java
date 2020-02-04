/*
 * This file is part of spark.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.lucko.spark.common.sampler.tick;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTickReporter implements TickReporter {
    private final Set<Callback> tasks = new HashSet<>();

    protected void onTick(double duration) {
        for (Callback r : this.tasks) {
            r.onTick(duration);
        }
    }

    @Override
    public void addCallback(Callback runnable) {
        this.tasks.add(runnable);
    }

    @Override
    public void removeCallback(Callback runnable) {
        this.tasks.remove(runnable);
    }

}
